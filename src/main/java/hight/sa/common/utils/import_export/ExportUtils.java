package hight.sa.common.utils.import_export;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

import static hight.sa.common.utils.DateUtils.toDateTimeString;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;
import static org.apache.commons.lang3.reflect.FieldUtils.getFieldsWithAnnotation;

/**
 * Created by neron.liu on 21/03/2017.
 */
@Slf4j
public class ExportUtils {

    private static final ConcurrentHashMap<String, Exportable> CACHE = new ConcurrentHashMap<>();

    public static <T> void exportExcelToResponse(List<T> data, Class<T> clazz, HttpServletResponse response) {
        Exportable exportable = CACHE.computeIfAbsent(clazz.getName(), className -> new Exportable(clazz));

        setHeaders(response);

        // 创建Excel文件主体
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建一个Sheet
        XSSFSheet sheet = workbook.createSheet("（" + data.size() + "）");

        addHeaderRowToSheet(exportable, sheet);

        addDataRowsToSheet(data, exportable, sheet);

        writeToResponse(response, workbook);
    }

    /**
     * 获取文件名，20160101121212.xls
     *
     * @return
     */
    private static String getFilename() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        return format.format(new Date()) + ".xls";
    }


    @Getter
    private static class Exportable {

        private String[] fieldsInOrder;

        /**
         * 属性名 -> 导出时的列名
         */
        private Map<String, String> exportHeaders;

        /**
         *
         */
        private Map<String, Field> cachedFields;

        Exportable(Class<?> clazz) {
            this.fieldsInOrder = clazz.getAnnotation(ExportOrder.class).fieldsInOrder();

            this.cachedFields = of(getFieldsWithAnnotation(clazz, Export.class))
                    .map(f -> {
                        f.setAccessible(true);
                        return f;
                    })
                    .collect(toMap(Field::getName, v -> v));

            this.exportHeaders = cachedFields.entrySet()
                    .stream()
                    .collect(toMap(Map.Entry::getKey, entry -> entry.getValue().getAnnotation(Export.class).name()));
        }

        Field getFieldWithIndex(int index) {
            return cachedFields.get(fieldsInOrder[index]);
        }

        String getNamedValueOfField(int index) {
            return getFieldWithIndex(index).getAnnotation(Export.class).name();
        }

        int getFieldSize() {
            return fieldsInOrder.length;
        }

    }

    /**
     * 设置Response的Header
     *
     * @param response
     */
    private static void setHeaders(HttpServletResponse response) {
        String filename = getFilename();

        response.addHeader("Content-type", "application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
    }

    /**
     * @param exportable
     * @param sheet
     */
    private static void addHeaderRowToSheet(Exportable exportable, XSSFSheet sheet) {
        XSSFRow header = sheet.createRow(0);

        IntStream.range(0, exportable.getFieldSize()).forEach(index -> {
            XSSFCell cell = header.createCell(index, CellType.STRING);

            cell.setCellValue(exportable.getNamedValueOfField(index));
        });
    }

    /**
     * @param data
     * @param exportable
     * @param sheet
     * @param <T>
     */
    private static <T> void addDataRowsToSheet(List<T> data, Exportable exportable, XSSFSheet sheet) {
        IntStream.range(1, data.size()).forEach(i -> {
            XSSFRow excelRow = sheet.createRow(i);

            T object = data.get(i);
            for (int j = 0; j < exportable.getFieldSize(); j++) {
                try {
                    Field field = exportable.getFieldWithIndex(j);

                    Object value = field.get(object);
                    if (value == null) {
                        excelRow.createCell(j, CellType.BLANK);
                    } else if (value instanceof Number) {
                        XSSFCell cell = excelRow.createCell(j, CellType.NUMERIC);
                        cell.setCellValue(NumberUtils.toDouble(value.toString()));
                    } else if (value instanceof String) {
                        XSSFCell cell = excelRow.createCell(j, CellType.STRING);
                        cell.setCellValue((String) value);
                    } else if (value instanceof Date) {
                        XSSFCell cell = excelRow.createCell(j, CellType.STRING);
                        cell.setCellValue(toDateTimeString((Date) value));
                    } else if (value instanceof Boolean) {
                        XSSFCell cell = excelRow.createCell(j, CellType.STRING);
                        cell.setCellValue(((Boolean) value) ? "是" : "否");
                    }
                } catch (Exception e) {
                    excelRow.createCell(j, CellType.BLANK);
                    log.error("Error while getting value.", e);
                }
            }
        });
    }

    private static void writeToResponse(HttpServletResponse response, XSSFWorkbook workbook) {
        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            log.error("Error happened while writing data to HTTP response.", e);
        }
    }

}

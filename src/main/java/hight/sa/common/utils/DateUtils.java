package hight.sa.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Created by neron.liu on 21/03/2017.
 */
public class DateUtils {

    public static String toDateTimeString(Date date) {
        if (Objects.isNull(date)) {
            return "";
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }

}

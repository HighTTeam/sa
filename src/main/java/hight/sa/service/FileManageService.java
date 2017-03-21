package hight.sa.service;

import hight.sa.common.SystemException;
import hight.sa.controller.admin.vo.StoreStatus;
import hight.sa.mapper.FileUploadLogMapper;
import hight.sa.model.FileUploadLog;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by neron.liu on 18/03/2017.
 */
@Log4j
@Service
public class FileManageService {

    @Value("file.storage_root_path")
    private String storageRootPath;

    @Autowired
    private FileUploadLogMapper fileUploadLogMapper;

    public List<StoreStatus> storeFiles(String fileOwner, MultipartFile[] files) {
        FilesHelper filesHelper = new FilesHelper(storageRootPath, files);

        try {
            filesHelper.createDirs();
        } catch (SystemException e) {
            log.error(e);
            return Collections.emptyList();
        }

        return filesHelper.getStatusList();
    }

    private class FilesHelper {

        private String storageRootPath;
        private MultipartFile[] files;
        private Path filesStorePath;

        private List<StoreStatus> statusList;

        FilesHelper(String storageRootPath, MultipartFile[] files) {
            this.storageRootPath = storageRootPath;
            this.files = files;

            // e.g. ${storageRootPath}/2017/3
            this.filesStorePath = getYearMonthBasedDirPath();
        }

        void createDirs() throws SystemException {
            if (Files.notExists(filesStorePath)) {
                try {
                    Files.createDirectories(filesStorePath);
                } catch (IOException e) {
                    throw SystemException.of(filesStorePath.toString() + " create failed!", e);
                }
            }
        }

        void deleteQuietly() {
            FileUtils.deleteQuietly(filesStorePath.toFile());
        }

        List<StoreStatus> getStatusList() {
            return statusList;
        }

        private Path getYearMonthBasedDirPath() {
            Calendar calendar = Calendar.getInstance();

            return Paths.get(
                    storageRootPath,
                    String.valueOf(calendar.get(Calendar.YEAR)),
                    String.valueOf(calendar.get(Calendar.MONTH)));
        }
    }

}

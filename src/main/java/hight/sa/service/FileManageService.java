package hight.sa.service;

import hight.sa.controller.admin.vo.StoreStatus;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by neron.liu on 18/03/2017.
 */
@Service
public class FileManageService {

    @Value("file.storage_root_path")
    private String storageRootPath;


    public List<StoreStatus> storeFiles(File[] files) {

        return null;
    }

    private class FilesHelper {

        private String storageRootPath;
        private File[] files;
        private Path filesStorePath;

        FilesHelper(String storageRootPath, File[] files) {
            this.storageRootPath = storageRootPath;
            this.files = files;

            // e.g. ${storageRootPath}/2017/3
            this.filesStorePath = getYearMonthBasedDirPath();
        }

        void createDirs() throws Exception {
            if (Files.notExists(filesStorePath)) {
                try {
                    Files.createDirectories(filesStorePath);
                } catch (IOException e) {
                    throw new Exception(filesStorePath.toString() + " create failed!", e);
                }
            }
        }

        Path getYearMonthBasedDirPath() {
            Calendar calendar = Calendar.getInstance();

            return Paths.get(
                    storageRootPath,
                    String.valueOf(calendar.get(Calendar.YEAR)),
                    String.valueOf(calendar.get(Calendar.MONTH)));
        }

        void deleteQuietly() {
            FileUtils.deleteQuietly(filesStorePath.toFile());
        }

    }

}

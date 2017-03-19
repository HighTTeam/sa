package hight.sa.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by neron.liu on 18/03/2017.
 */
@Controller
public class FileController {

    public ResponseEntity<?> upload(@RequestParam("uploadFiles") MultipartFile[] uploadFiles){
        return null;
    }

}

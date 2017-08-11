package com.example.springmvc.fileuploader;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller("/")
public class UploadController {

    @RequestMapping(value = "upload",produces = "application/json")
    @ResponseBody
    public String upload(HttpServletRequest request, MultipartFile file){
        String path = "/Users/lidechen/Desktop/java/ideaWorkspace/springmvc/src/main/webapp/WEB-INF/uploadfile";
        try {
            System.err.println("path = "+path);
            FileUtils.writeByteArrayToFile(new File(path,file.getOriginalFilename()),file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}

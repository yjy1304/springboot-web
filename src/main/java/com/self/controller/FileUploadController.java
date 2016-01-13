package com.self.controller;

import com.self.utils.UploadProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by wacai on 2016/1/12.
 */
@Controller
public class FileUploadController {
    @RequestMapping(value="/upload", method ={RequestMethod.POST,RequestMethod.GET})
    public String upload(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException{
        MultipartFile file = request.getFile("uploadFile");
        file.transferTo(new File("E:/test.txt"));
        return "...";
    }

    @RequestMapping(value="/init-upload")
    public String init(){
        return "/fileUpload";
    }
}

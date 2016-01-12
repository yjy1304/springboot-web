package com.self.controller;

import com.self.utils.UploadProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by wacai on 2016/1/12.
 */
@Controller
public class FileUploadController {
    public String upload(@RequestParam(value = "file") MultipartFile... files) throws IOException{
        for (MultipartFile f : files) {
            if (f.getSize() > 0) {
                File targetFile = new File("E:/temp.txt");
                f.transferTo(targetFile);//写入目标文件
            }
        }
        return "...";
    }
}

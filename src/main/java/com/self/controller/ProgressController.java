package com.self.controller;

import com.self.utils.FileUploadStatus;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * Created by wacai on 2016/1/12.
 */
@Controller
@SessionAttributes("status")
public class ProgressController {
    @RequestMapping(value="/progress", method = RequestMethod.POST)
    @ResponseBody
    public String initCreateInfo(Map<String, Object> model){
        FileUploadStatus fileUploadStatus = (FileUploadStatus)model.get("status");
        if(fileUploadStatus == null){
            return "{}";
        }
        return fileUploadStatus.toString();
    }


}

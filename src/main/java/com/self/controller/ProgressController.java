package com.self.controller;

import com.self.utils.FileUploadStatus;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by wacai on 2016/1/12.
 */
@Controller
public class ProgressController {
    @RequestMapping(value="/progress", method ={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String initProgressInfo(HttpServletRequest request) throws Exception{
        FileUploadStatus fileUploadStatus = (FileUploadStatus)request.getSession().getAttribute("fileUploadStatus");
        System.out.println("initprogress sid:" + request.getSession().getId());
        if(fileUploadStatus == null){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>status为空");
            return "{}";
        }else{
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>status有值啦");
            return fileUploadStatus.toString();
        }
    }


}

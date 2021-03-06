package com.self.utils;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wacai on 2016/1/12.
 */
@Component
public class UploadProgressListener implements ProgressListener{
    private HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
        FileUploadStatus fileUploadStatus = new FileUploadStatus();
        session.setAttribute("fileUploadStatus", fileUploadStatus);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>已经将status置入session,sid:" + session.getId() + "，status:" + fileUploadStatus.toString());
    }

    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
        FileUploadStatus fileUploadStatus = (FileUploadStatus) session.getAttribute("fileUploadStatus");
        fileUploadStatus.setBytesRead(pBytesRead);
        fileUploadStatus.setContentLength(pContentLength);
        fileUploadStatus.setItems(pItems);
    }
}

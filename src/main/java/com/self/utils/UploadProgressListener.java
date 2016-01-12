package com.self.utils;

import org.apache.commons.fileupload.ProgressListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wacai on 2016/1/12.
 */
public class UploadProgressListener implements ProgressListener{
    private HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
        FileUploadStatus fileUploadStatus = new FileUploadStatus();
        session.setAttribute("fileUploadStatus", fileUploadStatus);
    }

    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
        FileUploadStatus fileUploadStatus = (FileUploadStatus) session.getAttribute("fileUploadStatus");
        fileUploadStatus.setBytesRead(pBytesRead);
        fileUploadStatus.setContentLength(pContentLength);
        fileUploadStatus.setItems(pItems);
    }
}

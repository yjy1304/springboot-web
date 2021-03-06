package com.self.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.upload.CommonsMultipartRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wacai on 2016/1/12.
 */
public class CustomMultipartResolver extends CommonsMultipartResolver{

    @Override
    public MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException{
        String encoding = determineEncoding(request);
        FileUpload fileUpload = prepareFileUpload(encoding);
        UploadProgressListener uploadProgressListener = new UploadProgressListener();
        uploadProgressListener.setSession(request.getSession());
        fileUpload.setProgressListener(uploadProgressListener);
        try{
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
            return parseFileItems(fileItems, encoding);
        }catch (FileUploadBase.SizeLimitExceededException e){
            throw new MaxUploadSizeExceededException(fileUpload.getFileSizeMax(), e);
        }catch (FileUploadException e){
            throw new MultipartException("Could not parse multipart servlet request", e);
        }
    }
}

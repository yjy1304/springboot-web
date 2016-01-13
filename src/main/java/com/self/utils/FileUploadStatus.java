package com.self.utils;

/**
 * Created by wacai on 2016/1/12.
 */
public class FileUploadStatus {
    private long bytesRead;
    private long contentLength;
    private long items;

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public long getItems() {
        return items;
    }

    public void setItems(long items) {
        this.items = items;
    }

    @Override
    public String toString(){
        return "{\"bytesRead\":" +getBytesRead()+",\"contentLength\":"+getContentLength()+"}";
    }
}

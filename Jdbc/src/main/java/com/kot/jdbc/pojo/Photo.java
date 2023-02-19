package com.kot.jdbc.pojo;

/**
 * @author yf
 * @create 2022-12-10 19:54
 */
public class Photo {
    private int id;
    private String photoName;
    private byte[] photoBytes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public byte[] getPhotoBytes() {
        return photoBytes;
    }

    public void setPhotoBytes(byte[] photoBytes) {
        this.photoBytes = photoBytes;
    }
}

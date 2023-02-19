package com.kot.mybatis.pojo;

/**
 * @author yf
 * @create 2022-12-12 21:01
 */
public class Student {
    private int id;
    private String name;
    private int classId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}

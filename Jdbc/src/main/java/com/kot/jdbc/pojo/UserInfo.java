package com.kot.jdbc.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author yf
 * @create 2022-12-10 16:47
 */
public class UserInfo {
    private int id;
    private int uid;
    private String nickName;
    private int achievement;
    private int level;
    private String job;
    private Timestamp registerTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickName;
    }

    public void setNickname(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAchievement() {
        return achievement;
    }

    public void setAchievement(int achievement) {
        this.achievement = achievement;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", nickName='" + nickName + '\'' +
                ", achievement=" + achievement +
                ", level=" + level +
                ", job='" + job + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }
}

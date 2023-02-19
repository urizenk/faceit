package com.kot.mybatis.pojo;

/**
 * @author yf
 * @create 2022-12-12 21:00
 */
public class Amount {
    private int id;
    private String name;
    private int payed;
    private int remain;

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

    public int getPayed() {
        return payed;
    }

    public void setPayed(int payed) {
        this.payed = payed;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", payed=" + payed +
                ", remain=" + remain +
                '}';
    }
}

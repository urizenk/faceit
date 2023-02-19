package com.kot.io.bio;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author yf
 * @create 2022-11-30 15:04
 */
public class Person implements Serializable {
    String name;
    int age;
    String[]  otherInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Person(String name, int age, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }
}

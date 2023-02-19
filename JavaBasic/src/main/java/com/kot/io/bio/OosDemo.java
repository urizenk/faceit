package com.kot.io.bio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author yf
 * @create 2022-11-30 15:03
 */
public class OosDemo {
    /**
     * 对象序列化
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String name = "阿乐";
        int age = 19;
        String[] otherInfo = {"他是一个上单","在Lng打比赛"," 值50块钱"};

        Person person = new Person(name, age, otherInfo);
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\workspace\\faceit\\JavaBasic\\src\\main\\java\\com\\kot\\io\\bio\\person.obj");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(person);
        System.out.println("写出完毕");
        objectOutputStream.close();
        
    }
}

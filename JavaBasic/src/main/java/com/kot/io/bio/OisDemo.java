package com.kot.io.bio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author yf
 * @create 2022-11-30 15:21
 */
public class OisDemo {
    /**
     * 对象的反序列化
     * @param args
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("F:\\workspace\\faceit\\JavaBasic\\src\\main\\java\\com\\kot\\io\\bio\\person.obj");
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);

        Person p = (Person) objectInputStream.readObject();
        System.out.println(p.toString());
    }
}

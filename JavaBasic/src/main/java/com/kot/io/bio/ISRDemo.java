package com.kot.io.bio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author yf
 * @create 2022-11-30 15:34
 */
public class ISRDemo {
    /**
     * 使用转换流
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("F:\\workspace\\faceit\\JavaBasic\\src\\main\\java\\com\\kot\\io\\bio\\osw.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        int d;
        while ((d = isr.read()) != -1){
            System.out.println((char) d);
        }
        isr.close();

    }
}

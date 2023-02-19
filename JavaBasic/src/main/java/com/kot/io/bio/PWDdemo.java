package com.kot.io.bio;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yf
 * @create 2022-11-30 15:42
 */
public class PWDdemo {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter("F:\\workspace\\faceit\\JavaBasic\\src\\main\\java\\com\\kot\\io\\bio\\pw.txt","UTF-8");

        printWriter.println("我~~~~~~~~");
        printWriter.println("绵延悠长的爱啊~~~~~~~");
        System.out.println("写完了");
        printWriter.close();
    }
}

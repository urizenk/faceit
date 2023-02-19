package com.kot.io.bio;

import java.io.*;

/**
 * @author yf
 * @create 2022-11-30 0:34
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("F:\\workspace\\faceit\\JavaBasic\\src\\main\\java\\com\\kot\\io\\bio\\test.png");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\workspace\\faceit\\JavaBasic\\src\\main\\java\\com\\kot\\io\\bio\\test_cp.png");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int cur;
        long start = System.currentTimeMillis();
        while ((cur = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(cur);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:"+ (end - start) + "毫秒" );
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}

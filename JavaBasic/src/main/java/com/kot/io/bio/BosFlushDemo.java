package com.kot.io.bio;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author yf
 * @create 2022-11-30 14:51
 */
public class BosFlushDemo {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\workspace\\faceit\\JavaBasic\\src\\main\\java\\com\\kot\\io\\bio\\bos.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        String line = "这是新添加的一行";
        byte[] bytes = line.getBytes(StandardCharsets.UTF_8);
        bufferedOutputStream.write(bytes);
        System.out.println("写完啦");
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }
}

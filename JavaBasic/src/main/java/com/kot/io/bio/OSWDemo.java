package com.kot.io.bio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author yf
 * @create 2022-11-30 15:28
 */
public class OSWDemo {
    /**
     * 使用转换流将字节转换为字符
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("F:\\workspace\\faceit\\JavaBasic\\src\\main\\java\\com\\kot\\io\\bio\\osw.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        String line = "你好啊，你麻痹的";
        osw.write(line);
        osw.write("不好意思，不该骂人的");
        System.out.println("写完了");
        osw.close();
    }
}

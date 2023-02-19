package com.kot.io.bio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author yf
 * @create 2022-11-30 15:47
 */
public class PwDemo2 {
    /**
     * 对于pw的第二个demo
     * @param args
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("F:\\workspace\\faceit\\JavaBasic\\src\\main\\java\\com\\kot\\io\\bio\\pw2.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(osw);
        PrintWriter printWriter = new PrintWriter(writer);
        //简易的记事本功能

        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.nextLine();
            if("bye".equals(s)){
                break;
            }
            printWriter.println(s);
        }
        System.out.println("写完了");
        printWriter.close();
        System.out.println("关闭连接");
    }
}

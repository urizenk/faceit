package com.kot.multhr.thread;

/**
 * @author yf
 * @create 2022-12-01 22:09
 */
public class Bank {

    static int  count = 20;



    public  static void delCount(){
        count--;
    }

    public static synchronized void ComeIn(int n){
        for (int i = 0; i < n; i++) {
            if (count > 0){
                delCount();
            }
            break;
        }
    }


}

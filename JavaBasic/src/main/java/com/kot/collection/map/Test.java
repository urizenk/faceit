package com.kot.collection.map;

import java.util.*;

/**
 * @author yf
 * @create 2022-11-28 23:08
 */
public class Test {

    public void testHash(){
        int h;
        String s = "123";
        h = s.hashCode();
        h = h ^ h>>>16;
        h = 15 & h;
        System.out.println(h);
    }


    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();


        IdentityHashMap<Object, Object> objectObjectIdentityHashMap = new IdentityHashMap<>();
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        WeakHashMap<Object, Object> objectObjectWeakHashMap = new WeakHashMap<>();

        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        Properties properties = new Properties();
        new Test().testHash();

    }
}

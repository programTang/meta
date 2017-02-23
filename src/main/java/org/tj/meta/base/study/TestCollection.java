package org.tj.meta.base.study;

<<<<<<< HEAD
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.nio.file.FileSystem;
import java.util.TreeMap;
import java.util.WeakHashMap;
=======
import java.util.*;
>>>>>>> 03f2a9ea151aff7d7acd2a4a18a1ce227ab3b36c

/**
 * Created by liwenliwen on 16/12/19.
 * 此类主要用来学习Collection接口以及派生类
 */
public class TestCollection {
    private static int k = 0;
    public static void main(String[] args) {
        int j = 0;
        int n = 0;
        for (int i = 0; i < 100; i++){
            //System.out.println(i);
            j = j++;// 注意j
//            j++;
            k = k++;
//            k++;
            n = ++n;
        }
        System.out.println("n:="+n);  // 100
        System.out.println("j:="+j);  // 0
        System.out.println("k:="+k);  // 0
    }

<<<<<<< HEAD
    public static int testFinally(){
        int a = 0;
        try {
            new Exception().printStackTrace();
            throw new Exception();
        }catch (Exception e){
            a = 2;
            return a;
        }finally {
            a = 3;
        }
    }

    public static String testFinallyString(){
        String a ="0";
        try {
            a ="1";
            throw new Exception();
        }catch (Exception e){
            a = "2";
            return a;
        }finally {
            a = "3";
        }
=======
    public static void main(String[] args) {
//        List a = new ArrayList();
//        a.add("xixi");
//        a.add("haha");
        Map<String,String> map = new HashMap<>();
        map.put("a","b");
        System.out.println(map.size());
>>>>>>> 03f2a9ea151aff7d7acd2a4a18a1ce227ab3b36c
    }
}

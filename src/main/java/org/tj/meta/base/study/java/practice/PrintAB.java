package org.tj.meta.base.study.java.practice;

import java.io.PrintStream;

/**
 * Created by 001 on 17/2/13.
 * 要求调用method后，仅打印a=100,b=100；
 */
public class PrintAB {

//    public static void method(int a,int b){
//        System.out.println("a=100");
//        System.out.println("b=100");
//        System.exit(0);
//    }

    public static void method(int a,int b){
        PrintStream printStream  = new PrintStream(System.out){
            @Override
            public void println(String s) {
                if ("a=10".equals(s)){
                    s = "a=100";
                }else if ("b=10".equals(s)){
                    s = "b=100";
                }
                super.println(s);
            }
        };
        System.setOut(printStream);
    }

    public static void main(String[] args) {
        int a=10;
        int b=10;
        method(a,b);
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}

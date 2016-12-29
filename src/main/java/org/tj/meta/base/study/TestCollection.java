package org.tj.meta.base.study;

/**
 * Created by liwenliwen on 16/12/19.
 * 此类主要用来学习Collection接口以及派生类
 */
public class TestCollection {

    public static int testFinally(){
        int a = 0;
        try {
            a =1;
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
    }
}

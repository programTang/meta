package org.tj.meta.base.study;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liwenliwen on 16/12/19.
 * 此类主要用来学习Collection接口以及派生类
 */
public class TestCollection {

    public static void main(String[] args) throws FileNotFoundException {
//        List a = new ArrayList();
//        a.add("xixi");
//        a.add("haha");
//        char[] chars = {'a','b','c','d','e'};
//        System.arraycopy(chars,2,chars,3,2);
//        System.out.println(chars.length);
//        Stack<String> stack = new Stack();
//        Iterator i = a.iterator();
//        TestCollection testCollection = new TestCollection();
//        System.out.println(testCollection.hashCode());
        Map<String,String> map = new HashMap();
        map.put("ka", "kv");
        System.out.println(map.get("ka"));
        Writer writer = new OutputStreamWriter(new FileOutputStream(new File("build.gradle")));
    }
}

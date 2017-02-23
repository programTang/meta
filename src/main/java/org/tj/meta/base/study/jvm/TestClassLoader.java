package org.tj.meta.base.study.jvm;

/**
 * Created by 001 on 17/2/8.
 */
public class TestClassLoader {

    public static void main(String[] args) {
        System.out.println(Object.class.getClassLoader());
        System.out.println(TestClassLoader.class.getClassLoader());
    }
}

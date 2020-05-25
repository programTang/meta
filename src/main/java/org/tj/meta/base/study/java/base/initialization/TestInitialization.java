package org.tj.meta.base.study.java.base.initialization;


class Subclass2{

    static int i = 100;

    static {
        System.out.println("静态变量 i: " + i);
        System.out.println("静态方法块执行");
    }

    public static void test(){

    }
}

public class TestInitialization {

    public static void main(String[] args) {
//        Subclass2 subclass2 = new Subclass2();
//        System.out.println(Subclass2.i);
        Subclass2.test();
    }
}

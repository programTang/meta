package org.tj.meta.base.study.java.base.initialization;

/**
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 **/
class SuperClass {

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

class SubClass1 extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }
}

class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";
}


    /**
 * 非主动使用类字段演示
 **/
public class NotInitialization {

    public static void main(String[] args) {
//        System.out.println(SubClass1.value);
//SuperClass init!
//123

/**
 * 被动使用类字段演示二：
 * 通过数组定义来引用类，不会触发此类的初始化
 **/
//        SubClass1[] sca = new SubClass1[10];
//        sca[1] = new SubClass1();
        System.out.println(ConstClass.HELLOWORLD);

    }
}

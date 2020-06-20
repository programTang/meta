package org.tj.meta.base.study.java.base;

/**
 * 操作符训练
 */
public class Operation {

    public static void testInteger(){
        Integer n1 = new Integer(20);
        Integer n2 = new Integer(20);
        int n3 = 20;
        int n4 = new Integer(20); //自动拆包 基本类型

        Integer n5 = 20; //自动包装  调用 Integer.value() 从缓存池拿。
        Integer n6 = 20;

        Integer n7 = 129;
        Integer n9 = 129;
        Integer n8 = new Integer(129);

        System.out.println(n1 == n2); // false 指向堆里不同的两个对象
        System.out.println(n1 == n3); // true 自动拆包
        System.out.println(n1 == n4); // true 自动拆包
        System.out.println(n3 == n4); // true n4发生自动拆箱
        System.out.println(n1 == n5); // false
        System.out.println(n3 == n5); // true 自动拆包
        System.out.println(n5 == n6); // true value of  true 自动包装 享元
        System.out.println(n2 == n6); // false
        System.out.println(n7 == n8); // false
        System.out.println(n7 == n9); // false

    }

    public static void testInteger500(){
        Integer n1 = new Integer(500);
        Integer n2 = new Integer(500);
        int n3 = 500;
        int n4 = new Integer(500);

        Integer n5 = 500;
        Integer n6 = 500;

        System.out.println(n1 == n2); // false 指向堆里不同的两个对象
        System.out.println(n1 == n3); // false
        System.out.println(n1 == n4); // false
        System.out.println(n3 == n4); // true n4发生自动拆箱
        System.out.println(n1 == n5); // false
        System.out.println(n3 == n5); // true
        System.out.println(n5 == n6); // true value of  true 自动包装 享元

    }



    public static void testHex(){
        int a = 0x1f;
        int b = 0x7fffffff;
        int b1 = 0x7ffffffe;
        int c = Integer.MAX_VALUE;

        int e = -0x7fffffff;
        int f = Integer.MIN_VALUE;

        int g1 = (int) (Math.pow(2, 31) - 1);
        int g2 =  ((int)Math.pow(2, 31) - 1);
        int g3 =  ((int)Math.pow(2, 31));
        int g4 =  ((int)Math.pow(2, 32));
        float h = (float) (Math.pow(2, 31));



        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(b+1);
        System.out.println(Integer.toBinaryString(b));
        System.out.println("b1: "+b1);
        System.out.println("b1: "+Integer.toBinaryString(b1));

        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));

        System.out.println(e);
        System.out.println(Integer.toBinaryString(c));
        System.out.println(f);

        System.out.println(g1);
        System.out.println(g2);
        System.out.println(g3);
        System.out.println(g4);
        System.out.println(h);
    }

    public static void testBreak(){
        int i = 0;
        for (int j = 0; j < 10; j++) {

            for (int k = 0; k < 10; k++) {
                i++;
                break;
            }
            i++;
        }
        System.out.println(i);
    }



    public static void main(String[] args) {
        testInteger();
        System.out.println("------");
        testInteger500();
    }
}

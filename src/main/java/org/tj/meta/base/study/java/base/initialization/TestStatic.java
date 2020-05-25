package org.tj.meta.base.study.java.base.initialization;

public class TestStatic {

    static {
        i = 0;  //  给变量复制可以正常编译通过
//        System.out.print(i);  // 这句编译器会提示“非法向前引用”
    }
    
    static int i = 1;

    static int j = 1;

    static{
        j = 2;
    }

    public static void main(String[] args){
        System.out.println(TestStatic.i);  //1
        System.out.println(TestStatic.j); //2
        Parent parent = new Parent("aa");
        System.out.println(parent.p_StaticField_private);
    }
}
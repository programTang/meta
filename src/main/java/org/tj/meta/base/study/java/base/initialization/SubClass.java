package org.tj.meta.base.study.java.base.initialization;

import java.lang.reflect.Parameter;


class Parent {
    /* 静态变量 */
    public static String p_StaticField = "父类--静态变量";
    protected static String p_StaticField_private = "静态变量父类--静态变量";
    /* 变量 */
    public String    p_Field = "父类--变量";
    protected int    i    = 9;
    protected int    j    = 0;
    /* 静态初始化块 */
    static {
        System.out.println( p_StaticField );
        System.out.println( p_StaticField_private );
        System.out.println( "父类--静态初始化块" );
    }
    /* 初始化块 */
    {
        System.out.println( p_Field );
        System.out.println( "父类--初始化块" );
    }
    /* 构造器 */
    public Parent()
    {
        System.out.println( "父类--构造器" );
        System.out.println( "i=" + i++ + ", j=" + j );
        j = 20;
    }

    public Parent(String a)
    {
        System.out.println( "父类--有参构造器" );
        System.out.println( "i=" + i++ + ", j=" + j );
        j = 20;
    }
}

public class SubClass extends Parent {
    /* 静态变量 */
    public static String s_StaticField = "子类--静态变量";
    /* 变量 */
    public String s_Field = "子类--变量";
    /* 静态初始化块 */

    private int j;
    static {
        System.out.println( s_StaticField );
        System.out.println( p_StaticField_private );
        System.out.println( "子类--静态初始化块" );
    }
    /* 初始化块 */
    {
        System.out.println( s_Field );
        System.out.println( "子类--初始化块" );
    }
    /* 构造器 */
    private SubClass()
    {
        super("a");
        System.out.println( "子类--构造器" );
        System.out.println( "i=" + i + ",j=" + j );
    }

    public int getJ(){
        return super.j;
    }


    /* 程序入口 */
    public static void main( String[] args )
    {
        System.out.println( "子类main方法" );
        //不能用子类引用指向父类对象，强制转型可以编译通过，但是运行会报错
//        SubClass subClass = (SubClass) new Parent();
        //向上转型
        Parent parent = new SubClass();
        parent.toString();
        //向下转型
        SubClass subClass1 = (SubClass) parent;
        subClass1.toString();

        new SubClass();
    }
}
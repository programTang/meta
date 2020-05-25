package org.tj.meta.base.study.java.base.innerclass;

public class FuctionInnerClass {

    private int noStaticInt = 1;
    private static int STATIC_INT = 2;

    public void fun() {
        System.out.println("外部类方法");
    }

    public void testFunctionClass(){
        final int[] param = {10};

        int tmpParam = 0;

        class FunctionClass{
            private void fun(){
                System.out.println("局部内部类的输出");
                System.out.println(STATIC_INT);
                System.out.println(noStaticInt);
                noStaticInt++;
                param[0]++;
                System.out.println(tmpParam);;
                int j = tmpParam;
                System.out.println(++j);
                System.out.println("param0:" +param[0]);
                //params ++ ; // params 不可变所以这句话编译错误
            }
        }

        FunctionClass functionClass = new FunctionClass();
        functionClass.fun();
        System.out.println("param0:" +param[0]);


    }

    public static void main(String[] args) {
        FuctionInnerClass fuctionInnerClass = new FuctionInnerClass();
        fuctionInnerClass.testFunctionClass();
        System.out.println("noStaticInt:" + fuctionInnerClass.noStaticInt);
    }
}


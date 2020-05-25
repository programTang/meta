package org.tj.meta.base.study.java.base.innerclass;

public class OutClass {

    class InnerClass{

        int i;

        private InnerClass(){
            i = 10;
        }
    }

    class InnerClass2{
        int j;

        public InnerClass2(){
            System.out.println(new InnerClass().i);
        }
    }

    public static void main(String[] args) {
        InnerClass2 innerClass2 = new OutClass().new InnerClass2();

    }
}

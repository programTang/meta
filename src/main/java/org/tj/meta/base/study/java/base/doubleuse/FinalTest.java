package org.tj.meta.base.study.java.base.doubleuse;

class FinalClass{

    private int index;

    private final int s_index;

    private final FinalTest finalTest;

    public FinalClass(int index){
        System.out.println(index);
        this.s_index = index;
        finalTest = new FinalTest();
    }

    void setIndex(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    public int getFinalIndex(){
        return s_index;
    }
}

public class FinalTest {

    public final String s = null;

    private static void changeString(String a){
        a.concat("bbbb");
    }

    private static void changeStringBuilder(StringBuilder a){
        a.append("bbbb");
    }


    public static void main(String[] args) {
//        new FinalTest().s = "aa";
        FinalClass finalClass = new FinalClass(2);
//        finalClass = new FinalClass(2);
        System.out.println(finalClass.getFinalIndex());

        finalClass = new FinalClass(3);
        System.out.println(finalClass.getFinalIndex());

        final FinalClass finalClass1 = new FinalClass(1);
        System.out.println(finalClass1.getFinalIndex());

        final String a = new String("aaa");
        changeString(a);
        System.out.println(a);
        String ab = a;
        ab = new String("xxxx");
        System.out.println(ab);


        final StringBuilder b = new StringBuilder("aaa");
        changeStringBuilder(b);
        System.out.println(b);




    }
}

package org.tj.meta.base.study.java.base.enumnation;

/**
 * @author icourt1
 */

public enum Color{
    RED, YELLOW, GREEN;

    public static void main(String[] args){
        Color red = Color.RED;
        System.out.println(red);
        System.out.println(red.ordinal());
        System.out.println(red.getClass());
        System.out.println(Color.valueOf("RED"));
    }
}


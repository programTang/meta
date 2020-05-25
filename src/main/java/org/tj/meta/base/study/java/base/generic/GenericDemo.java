package org.tj.meta.base.study.java.base.generic;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class GenericDemo<T extends List> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        GenericDemo<ArrayList> genericDemo = new GenericDemo<>();
        genericDemo.setT(new ArrayList(2));
        System.out.println(genericDemo.getT().getClass().getName());
    }
}

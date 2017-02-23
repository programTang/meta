package org.tj.meta.base.study.java.thread.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 001 on 17/2/13.
 */
public class TestAtomic {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(10);
        System.out.println(integer.addAndGet(1));
        AtomicIntegerArray integerArray = new AtomicIntegerArray(100);
        AtomicReference atomicReference = new AtomicReference();
    }

}

package org.tj.meta.base.study.java.base;

import sun.misc.BASE64Decoder;

import java.util.AbstractList;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by 001 on 17/1/16.
 */
public class FinalPool implements Comparable{

    int size;

    public static void main(String[] args) {
//        String a1 = new String("myString");
//        String a2 = a1.intern();
////        String a2 = "myString";
//        System.out.println(a1 == a2);
//        Stack<Integer> stack = new Stack<>();
        FinalPool pool = new FinalPool();
        pool.size = 1;
        FinalPool pool1 = new FinalPool();
        pool1.size = 0;
        System.out.println(pool.compareTo(pool1));
        BASE64Decoder decoder = new BASE64Decoder();
//        LinkedHaputshMap
//        Vector
        ThreadLocal<FinalPool> finalPoolThreadLocal = new ThreadLocal<>();
        finalPoolThreadLocal.set(new FinalPool());
    }

    @Override
    public int compareTo(Object o) {
        FinalPool finalPool = (FinalPool) o;
        System.out.println(this.size);
        System.out.println(finalPool.size);
        return this.size > finalPool.size?1:-1;
    }
}

class MyList<E> extends AbstractList<E>{

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }
}
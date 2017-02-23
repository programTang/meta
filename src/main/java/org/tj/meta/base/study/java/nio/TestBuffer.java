package org.tj.meta.base.study.java.nio;


import com.sun.org.apache.bcel.internal.util.ClassPath;

/**
 * Created by 001 on 16/12/23.
 */
public class TestBuffer {

    public static void test() {

        System.out.println(new ClassPath().toString());
//        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
//        System.out.println("position:" + byteBuffer.position() + " limit: " + byteBuffer.limit() + " capacity: " + byteBuffer.capacity());;
//
//        byte [] bytes = {1,2,3,4,5,6,7,8,9,10,11,12};
//        byteBuffer.put(bytes);
//        System.out.println("position:" + byteBuffer.position() + " limit: " + byteBuffer.limit() + " capacity: " + byteBuffer.capacity());;
//        byteBuffer.flip();
//        System.out.println("position:" + byteBuffer.position() + " limit: " + byteBuffer.limit() + " capacity: " + byteBuffer.capacity());;
//
//        System.out.println(byteBuffer.getChar());
//        System.out.println("position:" + byteBuffer.position() + " limit: " + byteBuffer.limit() + " capacity: " + byteBuffer.capacity());;
//
////        byteBuffer.clear();
////        System.out.println("position:" + byteBuffer.position() + " limit: " + byteBuffer.limit() + " capacity: " + byteBuffer.capacity());;
//
//
//        byte[] bytes1 = {3,4,5,6,7,8,9,10,11,12};
//        byteBuffer.put(bytes1);
////        写入的byte超过10 会出问题，因为此时严格意义上来说是读模式，limit = bytebuffer里的前面写入的字节数，直接写入的话，最多只能写入 limit  - position 的字节数.
//        System.out.println("position:" + byteBuffer.position() + " limit: " + byteBuffer.limit() + " capacity: " + byteBuffer.capacity());;
//        byteBuffer.rewind();
//
//        System.out.println("position:" + byteBuffer.position() + " limit: " + byteBuffer.limit() + " capacity: " + byteBuffer.capacity());;
//        System.out.println(byteBuffer.getChar(2));
//
//        byteBuffer.clear();
//
//        System.out.println("position:" + byteBuffer.position() + " limit: " + byteBuffer.limit() + " capacity: " + byteBuffer.capacity());;
//        System.out.println(byteBuffer.getChar(2));
//通过查看原码  rewind 与 clear 的区别是 clear会把limit =  capacity ，而rewind 不会。
//clear 和 compact 的区别是compact 会把未读的数据（position~limit）放到放到buffer的起始位置,然后position 在最后一个未读元素的后面

    }
}

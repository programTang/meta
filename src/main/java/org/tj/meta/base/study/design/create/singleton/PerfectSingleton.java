package org.tj.meta.base.study.design.create.singleton;

/**
 * Created by 001 on 16/8/8.
 */
public class PerfectSingleton {

//    实际情况是，单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，
// 这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，
// 并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题。同时该方法也只会在第一次调用的时候使用互斥机制，
// 这样就解决了低性能问题。这样我们暂时总结一个相对完美的单例模式：
// 该种实现方式与饿汉式区别是 静态内部类是一个很特殊的类 它只有在被第一次被引用的时候才会加载类文件信息  这样就实现了线程安全的延迟加载。
    private PerfectSingleton(){

    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonHolder{
        private static PerfectSingleton instance = new PerfectSingleton();
    }

    /* 获取实例 */
    public static PerfectSingleton  getInstance(){
        return SingletonHolder.instance;
    }

    public Object readResolve() {
        return getInstance();
    }

    public static void main(String[] args) {
//饿汉式
        System.out.println(Integer.toUnsignedString(-123213));
//        Runtime.getRuntime();
//        NumberFormat.getInstance();

    }

}

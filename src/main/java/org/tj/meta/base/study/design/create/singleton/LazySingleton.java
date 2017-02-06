package org.tj.meta.base.study.design.create.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 001 on 16/8/8.
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(instance);
    }

//    最基本的
    private static LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
// 每次去拿单例都要的获取锁等待  实际上只要第一次线程竞争的时候获取锁就行了
    private static synchronized LazySingleton getInstance1(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

// 只有第一次线程竞争的时候才会获取锁 后面直接获取单例
//   但是还会有一个问题  在JVM中 创建对象和赋值操作实分开进行的 并且不保证执行的先后顺序 也就是说有可能AB线程 ，A获取锁，根据JVM的优化
//    机制，JVM有可能先给 Singletin 实例分配空间，然后就直接赋值给了instance变量，A线程离开同步块，B线程检测instance不为空，直接返回intance,有可能此时
//    JVM还没有完成初始化,所以B线程返回的为null;
   private static LazySingleton getInstance2(){
       if (instance == null){
           synchronized (LazySingleton.class){
               if (instance == null){
                   instance = new LazySingleton();
               }
           }
       }
       return instance;
   }

    public static void main(String[] args) {
        Set<LazySingleton> lazySingletons = new HashSet<>();
        Thread [] threads = new Thread[1000];
        long start_time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(() -> {
//                LazySingleton singleton = LazySingleton.getInstance();
//                LazySingleton singleton = LazySingleton.getInstance1();
                LazySingleton singleton = LazySingleton.getInstance2();
                lazySingletons.add(singleton);
                if (singleton == null){
                    System.out.println("当前线程获取到了null的Singleton");
                }
            });
        }

        for (int i = 0; i < 1000; i++) {
                threads[i].start();
        }

        for (int i = 0; i < 1000; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - start_time);
        System.out.println(lazySingletons.size());


    }

}

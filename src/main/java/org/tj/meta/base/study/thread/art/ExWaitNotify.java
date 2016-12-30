package org.tj.meta.base.study.thread.art;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 001 on 16/12/30.
 * wait 执行后立即释放锁 程序进入休眠状态
 * 值得注意的是执行 notify 后，线程并不会立即释放锁，而是要等到推出 synchronized 后才释放锁或者自己主动释放锁(wait())
 *
 */
public class ExWaitNotify {
    List<Object> products;
    int MAX = 50;

    public ExWaitNotify(){
        products = new ArrayList<>(30);
    }

    public ExWaitNotify(int num){
        products = new ArrayList<>(num);
        MAX = num;
    }

    public  void produce(int num){
        synchronized (products){
            while (true){
                if (products.size() <= MAX - num){
                    System.out.println("当前产品数量: "+products.size()+" 生产者 工作,生产"+num+"个产品");
                    for (int i = 0; i < num; i++) {
                        products.add(new Object());
                    }
                }else {
                    System.out.println("当前产品数量: "+products.size()+" 生产者 唤醒消费者，生产者阻塞");
                    products.notify();
                    try {
                        System.out.println("生产者阻塞,等待");
                        products.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public  void consume(int num){
        synchronized (products){
            while (true){
                if (products.size() >= num){
                    System.out.println("当前产品数量: "+products.size()+" 消费者 工作,消费"+num+"个产品");
                    for (int i = 0,k = products.size(); i < num; i++,k--) {
//                    int a =;
//                    System.out.println(a);
                        products.remove(k-1);
                    }
                }else {
                    System.out.println("当前产品数量: "+products.size()+",不够 消费者 一次消费："+num+" ,消费者 唤醒生产者生产");
                    products.notify();
                    try {
                        System.out.println("消费者阻塞,等待");
                        products.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ExWaitNotify exWaitNotify = new ExWaitNotify(50);
        Thread produceThread = new Thread(() -> exWaitNotify.produce(20));
        produceThread.setName("produce");

        Thread consumeThread = new Thread(() -> exWaitNotify.consume(10));
        consumeThread.setName("consume");

        consumeThread.start();
        produceThread.start();

    }
}

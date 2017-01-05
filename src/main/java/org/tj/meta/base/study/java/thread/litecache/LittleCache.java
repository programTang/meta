package org.tj.meta.base.study.java.thread.litecache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 001 on 17/1/4.
 * 用读写锁实现一个mini缓存系统
 */
public class LittleCache {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private Map<String,Object> cache = new HashMap<>();

    Object getData(String key){
        readLock.lock();
        Object o = null;
        try {
            o = cache.get(key);
            if (o == null){
                readLock.unlock();
                writeLock.lock();
                if (o == null) {
                    try {
                        o = System.currentTimeMillis();
                        cache.put(key,o);
                    }finally {
                        writeLock.unlock();
                    }

                }
                readLock.lock();
            }
        }finally {
            readLock.unlock();
        }
        return o;
    }

    void set(String key,Object o){
        writeLock.lock();
        try{
            cache.put(key,o);
        }finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        LittleCache littleCache = new LittleCache();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(littleCache.getData("a"));;
                }
            }).start();
        }
    }
}

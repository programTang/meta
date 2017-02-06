package org.tj.meta.base.study.design.create.singleton;

/**
 * Created by 001 on 16/8/22.
 */
public class HungrySingleton {

//    饿汉式单例模式 线程安全 因为是在类加载的时候初始化的 但是缺点是 不管你用不用这个单例 每次启动都要实例化 会浪费资源和时间
    private HungrySingleton hungrySingleton = new HungrySingleton();

    public HungrySingleton getInstance(){
        return hungrySingleton;
    }

}

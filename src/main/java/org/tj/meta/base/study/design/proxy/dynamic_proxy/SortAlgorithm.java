package org.tj.meta.base.study.design.proxy.dynamic_proxy;

import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * Created by 001 on 16/12/27.
 * 缺点是每一个需要计算函数的时间都需要通过接口先声明
 */
public interface SortAlgorithm {

    void straightInsertionSort();

    void shellSort();
}

class SortAlgorithmImpl implements SortAlgorithm{

    @Override
    public void straightInsertionSort() {
        try {
            Thread.sleep(Math.abs(new Random().nextLong())%10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shellSort() {
        try {
            Thread.sleep(Math.abs(new Random().nextLong())%10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TestSort{

    public static void main(String[] args) {
        SortAlgorithm sortAlgorithm = new SortAlgorithmImpl();
        SortAlgorithm sortAlgorithmProxy = (SortAlgorithm) Proxy.newProxyInstance(sortAlgorithm.getClass().getClassLoader(),sortAlgorithm.getClass().getInterfaces(),
                new AlgorithmTimeInvocationHandler(sortAlgorithm));
        sortAlgorithmProxy.shellSort();
        sortAlgorithmProxy.straightInsertionSort();
    }


}
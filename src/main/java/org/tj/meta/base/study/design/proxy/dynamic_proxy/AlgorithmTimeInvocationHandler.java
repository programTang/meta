package org.tj.meta.base.study.design.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 001 on 16/12/27.
 * 用动态代理实现的计算函数运行时间
 */
public class AlgorithmTimeInvocationHandler implements InvocationHandler {

    Object proxy;

    public AlgorithmTimeInvocationHandler(Object obj){
        this.proxy = obj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(proxy,args);
        System.out.println(method.getName()+" cost time : "+(System.currentTimeMillis() - startTime));
        return result;
    }
}


package org.tj.meta.base.study.design.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by 001 on 16/12/27.
 */
public class AlgorithmCglibProxy implements MethodInterceptor {

    public Enhancer enhancer = new Enhancer();
    Logger logger = LoggerFactory.getLogger(AlgorithmCglibProxy.class);
    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
//        通过字节码技术创建子类实例
        return enhancer.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        long start_time = System.currentTimeMillis();
        Object result = proxy.invokeSuper(obj,args);
        long cost_time = System.currentTimeMillis() - start_time;
        logger.info(method.getName()+" cost time: "+ cost_time);
        return result;
    }

}

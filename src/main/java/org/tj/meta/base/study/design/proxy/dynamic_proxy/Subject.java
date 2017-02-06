package org.tj.meta.base.study.design.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 001 on 16/12/27.
 * Java动态代理
 * 对比前面的静态代理，好处是如果要代理一个接口下面的多个方法（加入处理一致），不需要向原来一样每个方法都在代理类中实现，只需要一个方法就可以代理所有方法。
 * 实例：写一个动态代理 用来计算每一个方法的执行时间（做算法时需要）。
// * @see org.tj.meta.base.study.
 */
public interface Subject {
    void work();
    void sleep();
}

class RealSubject implements Subject{

    String name;

    RealSubject(String name){
        this.name = name;
    }
    @Override
    public void work() {
        System.out.println(name + " is doing sth");
    }

    public void sleep(){
        System.out.println(name + "is sleeping");
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object target;

    MyInvocationHandler(Object target){
        this.target = target;
    }

    public void preInvoke(){
        System.out.println("pre invoking");
    }

    public void afterInvoke(){
        System.out.println("after invoking");
    }

    @Override
    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
//        if (method.getName().equals("work")){
            preInvoke();
            Object result = method.invoke(target,args);
            afterInvoke();
            return result;
//        }else {
//            return method.invoke(target,args);
//        }
    }
}

class TestDynamicProxy{
    public static void main(String[] args) {
        Subject subject = new RealSubject("小红");
        InvocationHandler invocationHandler = new MyInvocationHandler(subject);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),invocationHandler);
        proxySubject.work();
        proxySubject.sleep();
    }
}



package org.tj.meta.base.study.design.proxy.static_proxy;

/**
 * Created by Administrator on 2016/12/26 0026.
 * 这就是java的静态代理模式  什么是代理模式
 * A：为其他对象提供一种代理以控制对这个对象的控制访问。
 */
public interface Subject {
        void work();
}

class RealSubject implements Subject{

    String name;

    public RealSubject(String name){
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println("Real Subject" + name +" is doing sth");
    }

}

class ProxySubject implements Subject{

    Subject subject ;

    public ProxySubject(Subject subject){
        this.subject = subject;
    }

    private void preWork(){
        System.out.println("pre working");
    }

    private void afterWork(){
        System.out.println("after working");
    }

    @Override
    public void work() {
        preWork();
        subject.work();
        afterWork();
    }
}

class Test{
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject("小明");
        Subject subject = new ProxySubject(realSubject);
        subject.work();
    }
}

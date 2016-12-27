package org.tj.meta.base.study.design.proxy.static_proxy;

/**
 * Created by Administrator on 2016/12/26 0026.
 * 这就是java的静态代理模式  什么是代理模式
 * A：为其他对象提供一种代理以控制对这个对象的控制访问。
 * 静态代理是在程序运行前 代理类的.class文件已经存在了。
 * 静态代理 每一个代理类只能为一个真实的类服务，如果需要代理的类很多，那么就需要很多代理类，势必会造成代码冗余，而这些代理类的代码几乎都是一样的
 * 所有这个时候需要动态代理，
 */
public interface Subject {
        void work();
        void sleep();
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

    @Override
    public void sleep() {
        System.out.println("Real Subject" + name +" is sleeping");
    }

}

class RealSubjectB implements Subject{

    @Override
    public void work() {
        System.out.println("B is working");
    }

    @Override
    public void sleep() {
        System.out.println("B is sleeping");
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

    @Override
    public void sleep() {
//        preWork();
        subject.sleep();
//        afterWork();
    }
}

class Test{
    public static void main(String[] args) {
        Subject realSubject = new RealSubject("小明");
        Subject subject = new ProxySubject(realSubject);
        subject.work();
        subject.sleep();

        Subject realSubjectB = new RealSubjectB();
        Subject subject1 = new ProxySubject(realSubjectB);
        subject1.work();
        subject1.sleep();

    }
}

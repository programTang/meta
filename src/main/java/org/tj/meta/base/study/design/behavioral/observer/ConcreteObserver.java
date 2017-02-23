package org.tj.meta.base.study.design.behavioral.observer;

/**
 * Created by Administrator on 2017/2/8 0008.
 */
public class ConcreteObserver extends Observer {

    String observerState;

    @Override
    void update(String state) {
        observerState = state;
        System.out.println("被观察对象状态修改为: "+state);
    }

    public static void main(String[] args) {
        Observer observer = new ConcreteObserver();
        ConcreteSubject subject = new ConcreteSubject();
        subject.addObserver(observer);
        subject.changeState("状态A");
        subject.changeState("状态B");
    }
}

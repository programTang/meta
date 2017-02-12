package org.tj.meta.base.study.design.behavioral.observer;

/**
 * Created by Administrator on 2017/2/8 0008.
 */
public class ConcreteSubject extends Subject {
    String state;

    void changeState(String state){
        this.state = state;
        notifyObserver(state);
    }

    public String getState() {
        return state;
    }
}

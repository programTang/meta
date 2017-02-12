package org.tj.meta.base.study.design.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/8 0008.
 */
public class Subject {

    List<Observer> observers = new ArrayList<>();

    void addObserver(Observer observer){
        observers.add(observer);
        System.out.println("增加观察者: "+observer);
    }

    void delObserver(Observer observer){
        observers.remove(observer);
        System.out.println("删除观察者: "+observer);
    }

    protected void notifyObserver(String state){
        for (Observer observer:observers){
            observer.update(state);
        }
    }
}

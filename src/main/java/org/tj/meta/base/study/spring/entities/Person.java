package org.tj.meta.base.study.spring.entities;

/**
 * Created by 001 on 17/1/12.
 */
public class Person {

    String name;

    Hand hand;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}

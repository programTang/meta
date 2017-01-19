package org.tj.meta.base.study.spring.entities;

/**
 * Created by 001 on 17/1/13.
 */
public class Hand {

    String left;
    String right;

    public Hand(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "left='" + left + '\'' +
                ", right='" + right + '\'' +
                '}';
    }
}

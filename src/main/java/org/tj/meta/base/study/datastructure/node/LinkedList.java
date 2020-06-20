package org.tj.meta.base.study.datastructure.node;

import java.util.List;

/**
 * 单链表的节点
 * @param <T>
 */
public class LinkedList<T> implements ILinkedList<T>{

    Node<T> head;

    Node<T> last;

    //链表长度
    int length = 0;


    @Override
    public boolean addFirst(T value) {
        Node node = new Node(value);
        if (head != null) {
            node.next = head;
        }
        head = node;
        length ++;
        return true;
    }

    @Override
    public boolean addNode(T afterT, T value) {
        return false;
    }

    @Override
    public boolean addLast(T value) {

        return false;
    }

    @Override
    public T getFirst() {
        if (head != null){
            return head.value;
        }
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void reverse() {

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(new Integer(1));
        linkedList.addFirst(new Integer(2));
        linkedList.addFirst(new Integer(3));
        System.out.println(linkedList.size());
        System.out.println(linkedList.getFirst());

    }
}




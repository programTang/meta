package org.tj.meta.base.study.datastructure.node;

public interface ILinkedList<T> {

    //插入头部
    boolean addFirst(T value);

    //插入某个节点之后，如果没有，就插入到最后面
    boolean addNode(T afterT, T value);

    //插入到链表末尾
    boolean addLast(T value);

    //获取头节点的值
    T getFirst();

    //获取末尾节点的值
    T getLast();

    //获取链表长度
    int size();

    //反转链表
    void reverse();

    class Node<T> {

        //链表存储的数据
        T value;

        //链表的下一个节点
        Node<T> next;

        public Node(T value){
            this.value = value;
        }

    }

}

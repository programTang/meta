package org.tj.meta.base.study.datastructure.node;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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

    public LinkedList(){
        head = last = null;
    }

    public LinkedList(T t){
        head.value = t;
        last.value = t;
        head = last;
        length++;
    }


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
        Node node = head;
        while (node.value.equals(afterT)){

        }
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
        "xxxx".substring()

    }
}


class Solution {

    public List<String> findSimilarImage(String targetImage, List<String> imageList) {

        if (CollectionUtils.isEmpty(imageList) || StringUtils.isEmpty(targetImage)){
            return new ArrayList<>();
        }
        //相似图片
        List<String> similarImage = new ArrayList<>();
        //最小海明距离
        int minImageDistance = getHaiMingDistance(targetImage, imageList.get(0));
        similarImage.add(imageList.get(0));
        for (int i = 1; i < imageList.size(); i++) {
            String currentImage = imageList.get(i);
            int currentDistance = getHaiMingDistance(targetImage, currentImage);
            if (currentDistance < minImageDistance){
                //移除
                similarImage.clear();
                similarImage.add(currentImage);
                minImageDistance = currentDistance;
            }else if(currentDistance == minImageDistance){
                similarImage.add(currentImage);
            }
        }
        return similarImage;
    }

    private int getHaiMingDistance(String a, String b){
        int distance = 0;
        if (StringUtils.isEmpty(a) && StringUtils.isEmpty(b)){
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)){
                    distance++;
                }
            }
        }
        return distance;
    }

}




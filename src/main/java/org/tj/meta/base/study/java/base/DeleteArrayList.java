package org.tj.meta.base.study.java.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 001 on 17/1/18.
 * 在遍历容器的时候删除元素
 */
public class DeleteArrayList {

    static class Student{
        int id;

        public Student(int id){
            this.id = id;
        }

        @Override
        public String toString() {
            return "id=" + id;
        }

    }

    public static void main(String[] args) throws IOException {
        List<Student> list = new ArrayList();
        for (int i = 0; i < 6; i++) {
            list.add(new Student(i));
        }


//        for (int i = 0,j = list.size(); i < j; i++) {
//        for (int i = 0; i < list.size(); i++) {
////            if (list.get(i).id == 3){
////                list.remove(i);
////                System.out.println(list.size());
////                System.out.println(list.get(3));
////            }
//
//            if (list.get(i).id == 0){
//                list.remove(i);
//                System.out.println(list.size());
////                System.out.println(list.get(4));
//            }
//            System.out.println(list.get(i));
//
//        }
//
//        for (Student i: list){
//            if (i.id == 4)
//                list.remove(i);
//        }

        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            Student s = iterator.next();
            if (s.id == 2){
//                list.remove(s);
                iterator.remove();
            }
            System.out.println(s);
        }

        System.out.println(list);
    }
}

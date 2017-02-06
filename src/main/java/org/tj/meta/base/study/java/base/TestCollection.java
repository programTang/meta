package org.tj.meta.base.study.java.base;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 001 on 17/1/16.
 */
public class TestCollection {


    static void constractMap(Map map){
        for (int i = 1000; i > 0; i--) {
            map.put(i,i);
        }
    }

    static void printMap(Map map){
        for (Object obj:map.keySet()){
            System.out.println(obj+" ： "+map.get(obj));
        }
    }

    public static void main(String[] args) {
//        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> map = new LinkedHashMap<>();
        constractMap(map);
        printMap(map);

    }
}

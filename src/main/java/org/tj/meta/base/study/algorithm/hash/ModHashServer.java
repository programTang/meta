package org.tj.meta.base.study.algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 001 on 16/12/28.
 * 分布式按取模hash 寻找服务器的方法，缺点是每增加或减少一台服务器  所有的值都要变动  所有的key都要重新计算hash存储。
 * 不能满足单调性  单调性：单调性是指如果已经有一些内容通过哈希计算分派到了相应的缓冲中，当又有新的缓冲加入到系统中时，哈希的结果应能够保证原有已分配的内容可以被映射到新的缓冲中去，而不会被映射到旧的缓冲集合中的其他缓冲区。
 */
public class ModHashServer {

    List<Map<Integer,Integer>> servers;

    public ModHashServer(int serverCount){
        servers = new ArrayList<Map<Integer, Integer>>(serverCount);
        for (int i=0;i<serverCount;i++){
            servers.add(new HashMap<Integer, Integer>());
        }
    }

    public List<Map<Integer, Integer>> getServers() {
        return servers;
    }

    public void put(int key,int value){
        int count = servers.size();
        servers.get(Math.floorMod(key,count)).put(key,value);
    }

    public void clear(){
        int size = servers.size();
        servers = new ArrayList<Map<Integer, Integer>>();
        for (int i=0;i<size;i++){
            servers.add(i,new HashMap<Integer, Integer>());
        }
    }

    public void reduceServer(int num){
        System.out.println(servers.size());
        if (num<1 || num>servers.size()){
            throw new IndexOutOfBoundsException();
        }
        Map<Integer,Integer> mapAll = getAllEntries();
        servers.remove(num);
        rehash(mapAll);
    }

    public void addServer(){
        Map<Integer,Integer> mapAll = getAllEntries();
        servers.add(new HashMap<Integer, Integer>());
        rehash(mapAll);
    }

    public Map<Integer,Integer> getAllEntries(){
        Map<Integer,Integer> mapAll = new HashMap<Integer, Integer>();
        for (Map<Integer,Integer>map:servers){
            mapAll.putAll(map);
        }
        return mapAll;
    }

    public void rehash(Map<Integer,Integer> mapAll){
        clear();
        for (int key:mapAll.keySet()){
            put(key,mapAll.get(key));
        }
    }

    public void print(){
        for (Map<Integer,Integer> map:getServers()){
            System.out.println(map.size());
        }
    }

//    public static void main(String[] args) {
//        int count = 5;
//        ModHashServer modHashServer = new ModHashServer(count);
////    假设初始化服务器数量为5
//        for (int i = 0; i < 100000; i++) {
//            modHashServer.put(i,i);
//        }
//        modHashServer.print();
//        modHashServer.reduceServer(3);
//        modHashServer.print();
//        modHashServer.reduceServer(3);
//        modHashServer.print();
//        modHashServer.addServer();
//        modHashServer.print();
//        modHashServer.addServer();
//        modHashServer.print();
//        modHashServer.addServer();
//        modHashServer.print();
//
//    }
}

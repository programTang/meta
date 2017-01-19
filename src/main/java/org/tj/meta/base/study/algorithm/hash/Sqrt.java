package org.tj.meta.base.study.algorithm.hash;

/**
 * Created by 001 on 16/12/30.
 */
public class Sqrt {

//    要求1. 不能 用Math.sqrt库  2. 求出来的误差绝对值 不能大于t
//    public static double sqrt(int v,double t) throws Exception {
//        if (v<0)
//            throw new Exception("");
//        int num = 0;
//        for ( ; num<t;num++){
//            if (num * num > v ){
//                break;
//            }
//        }
////        处于num -1 到 num 之间
//        for (; ; num+=t){
//
//        }
//
//    }
//
//
    public static double sqrt(int v,double t){
        if (v<0 || t<=0)
            throw new IllegalArgumentException();
        return sqrt0(0,v,v,t);
    }

    public static double sqrt0(double left,double right,int v,double t){
        double num = (left + right)/2;
        if (Math.abs(num*num - v) < t){
            return num;
        }else {
            if (num*num < v){
                return sqrt0(num,right,v,t);
            }else {
                return sqrt0(left,num,v,t);
            }
        }
    }

    public static void main(String[] args) {
//        int v = 9;
//        double t = 0.000000000000000000000001;
        int v = 9;
        double t = 0.1;
        System.out.println(Math.sqrt(v) - sqrt(v,t) );
        System.out.println(Math.abs(sqrt(v,t)));
        System.out.println(Math.sqrt(v));

    }
}

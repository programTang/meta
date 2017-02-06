package org.tj.meta.base.study.java.base.cast;

import java.util.Collections;

/**
 * Created by 001 on 17/2/6.
 * 只有当父类引用指向子类对象的时候  向下转型才不会出错。
 */
public class CastTest {

    static class CastSon extends CastTest{

    }

    static class CastSon1 extends CastTest{

    }

    public static void main(String[] args) {
        CastTest castTest = new CastSon1();
        CastSon castSon = (CastSon) castTest;

        CastTest castTest1 = new CastTest();
        CastSon castSon1 = (CastSon) castTest1;


    }
}

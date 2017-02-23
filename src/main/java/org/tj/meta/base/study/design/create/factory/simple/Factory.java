package org.tj.meta.base.study.design.create.factory.simple;

/**
 * Created by 001 on 17/2/8.
 */
public class Factory{

    public Product produceProduct(String name){
        switch (name){
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                System.out.println("wrong product name");
                return null;
        }
    }
}


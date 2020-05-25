package org.tj.meta.base.study.design.create.factory;

import org.springframework.beans.factory.BeanFactory;

/**
 * Created by Administrator on 2016/12/28 0028.
 */
public class ConceteCreator implements Creator {
    @Override
    public Product produceProduct() {
        return new ConcreteProduct();
    }
}

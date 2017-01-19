package org.tj.meta.base.study.datastructure.tree;

/**
 * Created by 001 on 17/1/5.
 */
public interface Tree<E>{

    /**
     * @return int the depth of tree;
     */
    int depth();

    E root();

    int size();

    boolean add(E e);

    boolean remove(Object object);

}

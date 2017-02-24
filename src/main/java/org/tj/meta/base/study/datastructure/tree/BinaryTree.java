package org.tj.meta.base.study.datastructure.tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 001 on 17/1/5.
 */
public class BinaryTree<E> implements Tree<E> {

    BinaryNode<E> root;

    public BinaryTree(){

    }

    public BinaryTree(E e){
        this.root = new BinaryNode<>(e);
    }

    /**
     * 树的深度
     * @return
     */
    @Override
    public int depth() {
        return depth(root);
    }

    private int depth(BinaryNode node){
        if (node == null){
            return 0;
        }
        int leftDepth,rightDepth;
        leftDepth = depth(node.getLeft())+1;
        rightDepth = depth(node.getRight())+1;
        return leftDepth>rightDepth?leftDepth:rightDepth;
    }

    @Override
    public E root() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean add(E e) {
        if (root == null){
            root = new BinaryNode<E>(e);
            return true;
        }
        return put(e);
    }

    /**
     * 从根节点往下 从左至右宽度优先遍历 插入
     * @param e
     * @return
     */
    private boolean put(E e){
        for (int i=1,j=depth();i<=j;i++){
            Queue<BinaryNode> queue = getTreeNodesByDepth(i);
            while (!queue.isEmpty()){
                BinaryNode node = queue.poll();
                if (node.getLeft() == null){
                    node.setLeft(new BinaryNode(e));
                    return true;
                }else if (node.getRight() == null){
                    node.setRight(new BinaryNode(e));
                    return true;
                }
            }
        }
        return false;
    }

    private Queue getTreeNodesByDepth(int depth){
        if (depth<1 || depth>depth()){
            return new ArrayDeque();
        }
        Queue queue = new LinkedBlockingQueue<TreeNode>();
        queue.add(root);
        for (int i = 1; i < depth; i++) {
            queue = getTreeNodesByQueue(queue);
        }
        return queue;
    }

    private Queue getTreeNodesByQueue(Queue<BinaryNode<E>> queue){
        Queue queue1 = new LinkedBlockingQueue();
        while (!queue.isEmpty()){
            BinaryNode node = queue.poll();
            if (node.getLeft() != null){
                queue1.add(node.getLeft());
            }
            if (node.getRight() != null){
                queue1.add(node.getRight());
            }
        }
        return queue1;
    }

//    public Queue preOrder(){
//
//    }
//

//    private void preOrder(Queue queue){
//
//    }

    @Override
    public boolean remove(Object object) {
        return false;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        System.out.println(binaryTree.depth());
//        binaryTree.put(4);
//        for (int i = 0; i < 10000; i++) {
//            binaryTree.add(i);
//        }
//        System.out.println(binaryTree.depth());
//        System.out.println(1<<13);
    }

}

package com.fishion.demo.datastructure.tree;

public class BinaryTree<E> {

    private BTree<E> root;


    public static class BTree<E> {
        private E item;
        private BTree<E> left;
        private BTree<E> right;

        public BTree(BTree<E> left, E item, BTree<E> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }


    }

}

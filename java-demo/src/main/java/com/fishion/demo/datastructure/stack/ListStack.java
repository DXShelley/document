package com.fishion.demo.datastructure.stack;

import java.util.Iterator;

public class ListStack<T> implements MyStack<T> {
    private Node<T> first;
    private int size;

    static class Node<T>{
        private Node<T> next;
        private T item;
    }
    @Override
    public MyStack<T> push(T item) {
        return null;
    }

    @Override
    public T pop() throws Exception {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}

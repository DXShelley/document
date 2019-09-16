package com.fishion.demo.datastructure.stack;

public interface MyStack<T> extends Iterable {
    MyStack<T>  push(T item);
    T pop() throws Exception;
    boolean isEmpty();
    int size();
}

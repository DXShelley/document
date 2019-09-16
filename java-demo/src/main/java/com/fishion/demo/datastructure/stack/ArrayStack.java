package com.fishion.demo.datastructure.stack;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> implements MyStack<T> {

    private T[] data = (T[]) new Object[1];
    private int size = 0;


    @Override
    public Iterator iterator() {

        // 返回逆序遍历的迭代器
        return new Iterator() {
            private int i = size;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public java.lang.Object next() {
                return data[--i];
            }
        };
    }

    @Override
    public MyStack push(T item) {
        check();
        data[size++] = item;
        return this;
    }

    private void check() {
        if (size >= data.length) {
            resize(2 * data.length);
        } else if (size > 0 && size <= data.length / 4) {
            resize(data.length / 2);
        }
    }

    private void resize(int si) {

        T[] temp = (T[]) new Object[si];

        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }


    @Override
    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is Empty!");
        }
        T item = data[--size];
        //System.arraycopy(data,);
        check();
        data[size] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public void print() {
        /*for (T t : data) {
            System.out.print(t);
        }*/
        System.out.println(Arrays.toString(data));
    }
}

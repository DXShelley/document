package com.fishion.demo.datastructure.stack;

import java.util.Iterator;

public class ListStack<T> implements MyStack<T> {
    private Node<T> first = null;
    private int size = 0;

    static class Node<T> {
        private Node<T> next;
        private T item;

        public Node(Node<T> next, T item) {
            this.next = next;
            this.item = item;
        }
    }

    @Override
    public MyStack<T> push(T item) {

        Node<T> newNode = new Node<>(first, item);
        first = newNode;
        size++;
        return this;
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }
        T item = first.item;
        first = first.next;
        size--;
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

    @Override
    public Iterator iterator() {

        return new Iterator() {
            private Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Object next() {
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    @Override
    public String toString() {
        Iterator<T> it = iterator();
        if (!it.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            T e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }
}

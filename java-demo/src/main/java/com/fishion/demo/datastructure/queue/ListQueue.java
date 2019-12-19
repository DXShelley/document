package com.fishion.demo.datastructure.queue;

import java.util.Iterator;

public class ListQueue<E> implements MyQueue<E> {

    private Node<E> first = null;
    private Node<E> last = null;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            return false;
        }
        Node<E> temp = last;
        Node<E> newNode = new Node<>(null, e);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        final Node<E> temp = first;
        if (isEmpty()) {
            throw new NullPointerException("队列为空");
        } else if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        size--;
        return temp.item;
    }

    @Override
    public E poll() {
        final Node<E> temp = first;
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        size--;
        return temp.item;
    }

    @Override
    public E peek() {
        return first.item;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            Node<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    static class Node<E> {
        private Node<E> next;
        private E item;

        public Node(Node<E> next, E item) {
            this.next = next;
            this.item = item;
        }
    }

    @Override
    public String toString() {
        Iterator<E> it = iterator();
        if (!it.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }

}

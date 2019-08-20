package com.fishion.demo.collection;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年08月06日 15:54
 */
public class MLinkedList<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public MLinkedList() {
    }

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    private void linkBefore(E e, Node<E> succ) {
        final Node<E> prev = succ.prev;
        final Node<E> newNode = new Node<>(prev, e, succ);
        succ.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;

    }

    private void linkAfter(E e, Node<E> prior) {
        final Node<E> succ = prior.next;
        final Node<E> newNode = new Node<>(prior, e, succ);
        prior.next = newNode;
        if (succ == null) {
            last = newNode;
        } else {
            succ.prev = newNode;
        }
        size++;
    }

    private static class Node<E> {
        private Node<E> prev;
        private E item;
        private Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

}

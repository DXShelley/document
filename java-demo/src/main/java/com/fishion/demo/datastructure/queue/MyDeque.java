package com.fishion.demo.datastructure.queue;

public interface MyDeque<E> extends MyQueue<E> {

    void addFirst(E item);

    boolean offerFirst(E item);

    boolean offer(E item);

    void addLast(E item);

    boolean offerLast(E item);

    E getFirst();

    E getLast();

    E peekFirst();

    E peekLast();

    E pollFirst();

    E pollLast();

    E removeFirst();

    E removeLast();

}

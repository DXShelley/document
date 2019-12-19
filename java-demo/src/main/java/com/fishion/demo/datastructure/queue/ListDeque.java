package com.fishion.demo.datastructure.queue;

import java.util.*;
import java.util.function.Consumer;

public class ListDeque<E> implements Deque<E> {

    private Node<E> first;
    private Node<E> last;
    int size = 0;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void addFirst(E e) {
        final Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;

        if (isEmpty()) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E e) {

        final Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (isEmpty()) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        final Node<E> f = first;
        final Node<E> next = first.next;
        final E item = f.item;

        f.next = null;
        f.item = null;

        first = next;
        if (first == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;

        return item;
    }

    @Override
    public E removeLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        final Node<E> l = last;
        final E item = l.item;
        final Node<E> prev = l.prev;

        l.prev = null;
        l.item = null;

        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;

        return item;
    }

    @Override
    public E pollFirst() {

        if (isEmpty()) {
            return null;
        }
        final E item = first.item;
        removeFirst();
        return item;
    }

    @Override
    public E pollLast() {

        if (isEmpty()) {
            return null;
        }

        final E item = last.item;
        removeLast();
        return item;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return first.item;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        for (Node<E> x = last; x != null; x = x.prev) {
            if (o == null && x.item == null) {
                remove(x);
                return true;
            }
            if (o != null && o.equals(x.item)) {
                remove(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public void push(E e) {

        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        /*
         * for (Node<E> x = first; x != null; x = x.next) { if (o == null && x.item ==
         * null) { remove(x); return true; }
         * 
         * if (o != null && o.equals(x.item)) { remove(x); return true; }
         * 
         * }
         */

        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    remove(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    remove(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null;) {
            Node<E> temp = x.next;
            x.item = null;
            x.prev = null;
            x.next = null;
            x = temp;
        }

        first = last = null;
        size = 0;

    }

    @Override
    public boolean contains(Object o) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        int i = 0;
        Object[] result = new Object[size];
        for (Node<E> x = first; x != null; x = x.next) {
            result[i++] = x.item;
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    public E remove(Node<E> x) {
        final E item = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;

        x.item = null;
        x.prev = null;
        x.next = null;

        if (prev == null) {
            next.prev = null;
            first = next;
        } else {
            next.prev = prev;
        }

        if (next == null) {
            prev.next = null;
            last = prev;
        } else {
            prev.next = next;
        }
        size--;
        return item;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private class ListItr implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        ListItr(int index) {
            // assert isPositionIndex(index);
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            // checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            // checkForComodification();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.item;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            // checkForComodification();
            if (lastReturned == null) {
                throw new IllegalStateException();
            }

            Node<E> lastNext = lastReturned.next;
            ListDeque.this.remove(lastReturned);
            if (next == lastReturned) {
                next = lastNext;
            } else {
                nextIndex--;
            }
            lastReturned = null;
            // expectedModCount++;
        }

        @Override
        public void set(E e) {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            // checkForComodification();
            lastReturned.item = e;
        }

        @Override
        public void add(E e) {
            // checkForComodification();
            lastReturned = null;
            if (next == null) {
                addLast(e);
            } else {
                addBefore(e, next);
            }
            nextIndex++;
            // expectedModCount++;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            /*
             * while (modCount == expectedModCount && nextIndex < size) {
             * action.accept(next.item); lastReturned = next; next = next.next; nextIndex++;
             * }
             */
            // checkForComodification();
        }

    }

    Node<E> node(int index) {
        checkElementIndex(index);
        if (index < (size >> 1)) {
            Node<E> f = first;
            for (int i = 1; i < index; i++) {
                f = f.next;
            }
            return f;
        } else {
            Node<E> l = last;
            for (int i = size - 1; i > index; i--) {
                l = l.prev;
            }
            return l;
        }
    }

    void addBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev;
        Node<E> newNode = new Node<>(pred, e, succ);

        succ.prev = newNode;

        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
}

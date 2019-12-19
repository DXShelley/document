package com.fishion.demo.datastructure.queue;

public class TestQueue {
    public static void main(String[] args) {
        ListQueue<String> listQueue = new ListQueue<>();
        System.out.println(listQueue.toString());
        listQueue.add("1");
        System.out.println(listQueue.toString());
        listQueue.add("2");
        System.out.println(listQueue.toString());
        listQueue.add("3");
        System.out.println(listQueue.toString());
        listQueue.remove();
        System.out.println(listQueue.toString());
        listQueue.remove();
        System.out.println(listQueue.toString());
        listQueue.add("4");
        System.out.println(listQueue.toString());
        listQueue.remove();
        listQueue.remove();
        System.out.println(listQueue.toString());

        listQueue.remove();
        System.out.println(listQueue.toString());

    }
}

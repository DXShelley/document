package com.fishion.demo.datastructure.stack;

public class TestStack {
   /* public static void main(String[] args) throws Exception {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("1");
        arrayStack.print();
        arrayStack.push("2");
        arrayStack.print();
        arrayStack.push("3");
        arrayStack.print();
        arrayStack.push("4");
        arrayStack.print();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.print();
        arrayStack.push("5");
        arrayStack.push("6");
        arrayStack.push("7");
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();
        arrayStack.print();
    }*/

    public static void main(String[] args) throws Exception {
        ListStack<String> listStack = new ListStack <>();
        System.out.println(listStack.toString());
        listStack.push("1");
        System.out.println(listStack.toString());
        listStack.push("2");
        listStack.push("3");
        System.out.println(listStack.toString());
        listStack.push("4");
        System.out.println(listStack.toString());
        listStack.pop();
        listStack.pop();
        System.out.println(listStack.toString());
        listStack.push("5");
        listStack.push("6");
        System.out.println(listStack.toString());
        listStack.push("7");
        System.out.println(listStack.toString());
        listStack.pop();
        listStack.pop();
        listStack.pop();
        System.out.println(listStack.toString());
    }
}

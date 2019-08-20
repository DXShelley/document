package com.fishion.demo.consumerdemo;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月11日 9:41
 */
public class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printData() {
        System.out.println("Name:" + name + " age:" + age);
    }
}

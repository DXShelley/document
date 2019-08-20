package com.fishion.demo.consumerdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import com.google.common.collect.Lists;

import static java.util.stream.Collectors.toList;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月11日 9:40
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        ConsumerDemo consumerDemo = new ConsumerDemo();
//    consumerDemo.demo1();
//        consumerDemo.demo2();
        consumerDemo.demo3();
    }

    public void demo1() {
        List<Student> list = new ArrayList();
        list.add(new Student("Ram", 20));
        list.add(new Student("Shyam", 22));
        list.add(new Student("Kabir", 18));
        // Creating instance of Consumer functional interface
        Consumer<Student> style = (Student s) -> System.out.println("Name:" + s.name + " and Age:" + s.age);
        // first way using Consumer
        list.forEach(style);
        // second way using method reference
        list.forEach(Student::printData);
        // third way using lambda expression
        list.forEach(s -> s.printData());

        list.forEach(Student::printData);
        list.forEach(e -> e.printData());
        list.forEach((Student s) -> System.out.println(s.age));

        Consumer<Student> consumer = student -> System.out.println(student.name);
    }

    public void demo2() {
        System.out.println("--IntConsumer--");
        int[] intNum = {3, 5, 6, 10, 15};
        IntConsumer intCon = i -> System.out.print(i + " ");
        Arrays.stream(intNum).forEach(intCon);

        System.out.println("\n--LongConsumer--");
        long[] longNum = {13l, 9l, 6l, 10l, 15l};
        LongConsumer longCon = l -> System.out.print(l + " ");
        Arrays.stream(longNum).forEach(longCon);

        System.out.println("\n--DoubleConsumer--");
        double[] dbNum = {13.4d, 9.1d, 6.5d, 10.3d, 15.3d};
        DoubleConsumer dbCon = d -> System.out.print(d + " ");
        Arrays.stream(dbNum).forEach(dbCon);

    }

    public void demo3() {
        List<Integer> list = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        System.out.println("-----------1------------");
        list.stream().filter(num -> num != null).peek(e -> System.out.print(e + "  ")).collect(toList());
        System.out.println();
        System.out.println("-----------2------------");
        list.stream().filter(num -> num != null).distinct().peek(e -> System.out.print(e + "  ")).collect(toList());
        System.out.println();

        System.out.println("-----------3------------");
        list.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(e -> System.out.print(e + "  ")).sum();
        System.out.println();

        System.out.println("-----------4------------");
        list.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).skip(2).peek(e -> System.out.print(e + "  ")).sum();
        System.out.println();

        System.out.println("-----------5------------");
        list.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).skip(2).limit(4).peek(e -> System.out.print(e + "  ")).sum();

        System.out.println();
        System.out.println("-----------6------------");
        System.out.println(list.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).skip(2).limit(4).peek(e -> System.out.print(e + "  ")).sum());
    }
}

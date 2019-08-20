package com.fishion.demo.collection.list;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年05月05日 9:22
 */
public class ListToSet {
    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayList("1", "2", "3", "3");
        Set<String> stringSet = new HashSet<String>(stringList);
        System.out.println(stringList.toString());
        System.out.println(stringSet.toString());


        for (String s : stringSet) {

        }

        for (Iterator<String> iterator = stringSet.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();

        }

        for (int i = 0; i < stringList.size(); i++) {
            String s = stringList.get(i);

        }

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];


        }


    }
}

package com.fishion.demo;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月16日 14:59
 */
public class guava {
    public static void main(String[] args) {
        Table<String, String, String> table = HashBasedTable.create();
        table.put("1", "2", "aaa");
        table.put("3", "4", "bbb");
        if (table.contains("1", "2")) {
            System.out.println(true);
        }
        String str = null;
        System.out.println(str);

    }
}

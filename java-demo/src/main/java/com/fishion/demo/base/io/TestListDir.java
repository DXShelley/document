package com.fishion.demo.base.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月22日 10:56
 */
public class TestListDir {

    public static void main(String[] args) {
//        ListFileNames();
        ListFiles();
    }

    public static void ListFileNames() {
        File userHomeDir = new File(System.getProperty("user.home"));
        System.out.println(userHomeDir.getAbsolutePath());

        String[] content = userHomeDir.list();

        for (String entry : content) {
            System.out.println(entry);
        }
    }


    public static void ListFiles() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File file, String name) {
                return name.startsWith("sunway");
            }
        };

        String[] content = currentDir.list(filter);

        for (String entry : content) {
            System.out.println(entry);
        }
    }
}

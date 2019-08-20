package com.fishion.demo.base.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月18日 9:03
 */
public class TestFileOutputstreamAppends {
    public static void main(String[] args) {
        Path path = Paths.get("F:\\tmp\\demo\\file\\test.txt");
        List<String> stringList = Lists.newArrayList("hello 1", "hello 2", "hello 3");

        try (OutputStream fos = Files.newOutputStream(path)) {
            for (String str : stringList) {
                byte[] bytes = str.getBytes();
                fos.write(bytes);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}

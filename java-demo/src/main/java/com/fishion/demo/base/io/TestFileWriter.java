package com.fishion.demo.base.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月18日 10:19
 */
public class TestFileWriter {
    public static void main(String[] args) {
        Path path = Paths.get("F:\\tmp\\demo\\file\\test.txt");
        List<String> stringList = Lists.newArrayList("hello 4", "hello 5", "hello 6");

        WriteByFileWriter(path);
//        WriteByBufferedWriter(path,stringList);

    }

    public static void WriteByFileWriter(Path path) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path.toFile(), true);
            List<String> stringList = Lists.newArrayList("hello 1", "hello 2", "hello 3");
            for (String str : stringList) {
                fileWriter.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static void WriteByBufferedWriter(Path path, List<String> strList) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {

            for (String str : strList) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {


        }
    }
}

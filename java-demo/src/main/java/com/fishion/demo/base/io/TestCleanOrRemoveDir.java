package com.fishion.demo.base.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.list;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月19日 11:03
 */
public class TestCleanOrRemoveDir {

    public static void main(String[] args) {
        Path source = Paths.get("J:\\demo\\file");
        try {
            cleanDirectory(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 清空目录及子目录下文件
     */
    public static void cleanDirOrSubDir(Path dirPath) throws IOException {

        if (Files.isDirectory(dirPath)) {
            Stream<Path> fileList = list(dirPath);
            fileList.forEach(e -> {
                try {
                    if (Files.isDirectory(e)) {
                        cleanDirOrSubDir(e);
                    } else {
                        Files.deleteIfExists(e);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        } else {
            Files.deleteIfExists(dirPath);
        }
    }

    /*
     * 删除目录
     */
    public static void removeDirectory(Path dirPath) throws IOException {

        if (Files.isDirectory(dirPath)) {
            List<Path> pathList;
            try (Stream<Path> fileList = list(dirPath)) {
                pathList = fileList.collect(Collectors.toList());
                for (Path path : pathList) {
                    if (Files.isDirectory(path)) {
                        removeDirectory(path);
                    } else {
                        Files.delete(path);
                    }
                }
            }
            Files.deleteIfExists(dirPath);
        }
    }

    /*
     * 清空目录
     */
    public static void cleanDirectory(Path dir) throws IOException {
        if (Files.isDirectory(dir)) {
            try (DirectoryStream<Path> fileList = Files.newDirectoryStream(dir)) {
                for (Path entry : fileList) {
                    if (Files.isDirectory(entry)) {
                        removeDirectory(entry);
                    } else {
                        Files.delete(entry);
                    }
                }
            }
        }
    }

}

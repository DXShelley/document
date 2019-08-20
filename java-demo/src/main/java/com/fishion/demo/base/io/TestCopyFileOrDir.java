package com.fishion.demo.base.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月18日 17:08
 */
public class TestCopyFileOrDir {

    public static void main(String[] args) {
        Path source = Paths.get("F:\\tmp\\demo\\file");
        Path target = Paths.get("F:\\tmp\\demo2\\file2");
//        CopyFile(source,target);
        CopyDir(source, target);
    }

    public static void CopyFile(Path source, Path target) {

        try {
            target.getRoot();
            Path dirPath = target.getParent();
            if (!dirPath.toFile().exists()) {
                Files.createDirectories(target.getParent());
            }
            target = Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CopyDir(Path source, Path target) {

        try {
            Files.walkFileTree(source, new CopyDir(source, target));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

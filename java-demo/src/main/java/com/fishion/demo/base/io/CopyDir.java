package com.fishion.demo.base.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月18日 22:08
 */
public class CopyDir extends SimpleFileVisitor<Path> {
    private Path sourceDir;
    private Path targetDir;

    public CopyDir(Path sourceDir, Path targetDir) {
        this.sourceDir = sourceDir;
        this.targetDir = targetDir;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {

        try {
            Path targetFile = targetDir.resolve(sourceDir.relativize(file));
            Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attributes) {
        try {
            Path newDir = targetDir.resolve(sourceDir.relativize(dir));
            Files.createDirectories(newDir);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        return FileVisitResult.CONTINUE;
    }

}
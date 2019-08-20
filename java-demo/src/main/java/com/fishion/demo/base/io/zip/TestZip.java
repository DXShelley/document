package com.fishion.demo.base.io.zip;

import java.io.*;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月19日 14:50
 */
public class TestZip {

    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        String zipFilePath = "F:\\tmp\\demo\\sunway-app-casic201";
        String destDirectory = "J:\\demo\\file\\target2.zip";
        zipDirectory(Paths.get(zipFilePath), Paths.get(destDirectory));
    }

    public static void unZip(Path source, Path target) throws IOException {

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(source))) {

            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                Path targetRealPath = target.resolve(zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    Files.createDirectories(targetRealPath);
                } else {
                    extractFile(zipInputStream, targetRealPath);
                }
                System.out.println(targetRealPath.toString());

                zipInputStream.closeEntry();

                zipEntry = zipInputStream.getNextEntry();
            }
        }

    }

    public static void zipDirectory(Path source, Path target) throws IOException {

        if (Files.exists(target)) {
            Files.deleteIfExists(target);
            Files.createFile(target);
        }
        if (!Files.exists(source)) {
            return;
        }
        try (OutputStream fos = Files.newOutputStream(target, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(fos)) {
                zip(source, source, zipOutputStream);
            }
        }
    }

    public static void zip(Path rootDirSource, Path realFileSource, ZipOutputStream target) throws IOException {
        if (Files.isDirectory(realFileSource)) {
            try (DirectoryStream<Path> paths = Files.newDirectoryStream(realFileSource)) {
                for (Path path : paths) {
                    if (Files.isDirectory(path)) {
                        zip(rootDirSource, path, target);
                    } else {
                        Path tmpRelativePath = rootDirSource.relativize(path);
                        ZipEntry zipEntry = new ZipEntry(File.separator + tmpRelativePath.toString());
                        compressFile(target, path, zipEntry);
                    }
                }
            }

        } else {
            ZipEntry zipEntry = new ZipEntry(realFileSource.toFile().getName());
            compressFile(target, rootDirSource, zipEntry);
        }
    }

    public static void extractFile(ZipInputStream in, Path target) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(target));
        byte[] buffer = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = in.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, read);
        }
        bufferedOutputStream.close();
    }

    public static void compressFile(ZipOutputStream zout, Path soure, ZipEntry zipEntry) throws IOException {
        zout.putNextEntry(zipEntry);
        try (SeekableByteChannel seekableByteChannel = Files.newByteChannel(soure)) {
            if (seekableByteChannel.size() > (long) (Integer.MAX_VALUE - 8)) {

                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(soure))) {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int read = 0;
                    while ((read = bufferedInputStream.read(buffer)) != -1) {
                        zout.write(buffer, 0, read);
                    }
                }
            } else {
                byte[] bytes = Files.readAllBytes(soure);
                zout.write(bytes, 0, bytes.length);
            }
        }
        zout.closeEntry();
    }
}

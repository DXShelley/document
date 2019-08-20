package com.fishion.demo.base.io.zip;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月22日 11:40
 */
public class ReadZipFile {

    private static void read(String zipFilePath) {
        try {
            ZipFile zipFile = new ZipFile(zipFilePath);

            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                String name = entry.getName();
                long compressedSize = entry.getCompressedSize();
                long normalSize = entry.getSize();
                String type = entry.isDirectory() ? "DIR" : "FILE";

                System.out.println(name);
                System.out.format("\t %s - %d - %d\n", type, compressedSize, normalSize);
            }

            zipFile.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {

        String zipFilePath = "F:\\tmp\\demo\\sunway-app-casic201.zip";
        read(zipFilePath);
    }
}

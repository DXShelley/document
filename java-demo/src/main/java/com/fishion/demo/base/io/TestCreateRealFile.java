package com.fishion.demo.base.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月22日 10:30
 */
public class TestCreateRealFile {

    public static void main(String[] args) throws IOException {

        createTempFile();

    }

    public void createEmptyFile() throws IOException {

        String userHomeDir = System.getProperty("user.home");
        System.out.println(userHomeDir);
        String path = userHomeDir + File.separator + "Code.java";
        System.out.println(File.separator);

        File file = new File(path);
        boolean created = file.createNewFile();
        System.out.println(created);

        /*
         * File file = new File("J:\\demo\\file\\Code.java"); file.createNewFile();
         */
        /*
         * boolean created = false; try { created = file.createNewFile(); } catch
         * (IOException e) { e.printStackTrace(); }
         *
         * if (created) { System.out.println("The file has been created"); }
         */

    }

    public static void createTempFile() {
        try {
            File tempFile = File.createTempFile("CodeJava", ".log");
            System.out.println(tempFile.getAbsolutePath());
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write("I love Java");
            writer.close();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

}

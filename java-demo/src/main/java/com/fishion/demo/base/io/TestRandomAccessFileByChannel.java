package com.fishion.demo.base.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;


public class TestRandomAccessFileByChannel {

    public void read(Path file) {
        ByteBuffer buffer = null;

        try (FileChannel fc = FileChannel.open(file, READ)) {
            fc.position(fc.size() - 128);
            buffer = ByteBuffer.allocate(3);

            do {
                fc.read(buffer);
            } while (buffer.hasRemaining());

            String tag = new String(buffer.array(), Charset.defaultCharset());

            if (!"TAG".equals(tag)) {
                System.out.println("This file doesn't support ID3v1");
                System.exit(0);
            }

            buffer = ByteBuffer.allocate(30);

            do {
                fc.read(buffer);
            } while (buffer.hasRemaining());

            String songName = new String(buffer.array());

            System.out.println("Song name: " + songName);

            buffer.clear();

            do {
                fc.read(buffer);
            } while (buffer.hasRemaining());

            String artist = new String(buffer.array());

            System.out.println("Artist: " + artist);

            buffer.clear();

            do {
                fc.read(buffer);
            } while (buffer.hasRemaining());

            String album = new String(buffer.array());

            System.out.println("Album: " + artist);


            buffer = ByteBuffer.allocate(4);

            do {
                fc.read(buffer);
            } while (buffer.hasRemaining());

            String year = new String(buffer.array());

            System.out.println("Year: " + year);

        } catch (IOException ex) {
            System.err.println("I/O Error: " + ex);
        }
    }

    public void updateSongName(Path file, String songName) {
        ByteBuffer buffer = null;

        try (FileChannel fc = FileChannel.open(file, READ, WRITE)) {
            fc.position(fc.size() - 128);
            buffer = ByteBuffer.allocate(3);

            do {
                fc.read(buffer);
            } while (buffer.hasRemaining());

            String tag = new String(buffer.array());

            if (!"TAG".equals(tag)) {
                System.out.println("This file doesn't support ID3v1");
                System.exit(0);
            }

            buffer = ByteBuffer.wrap(songName.getBytes());

            while (buffer.hasRemaining()) {
                fc.write(buffer);
            }

            fc.close();

        } catch (IOException ex) {
            System.err.println("I/O Error: " + ex);
        }
    }


    public static void main(String[] args) {
        Path path = Paths.get("F:\\tmp\\demo\\file\\Bandari - 重回心灵花园.mp3");
        String songName = "helloworld.mp3";
        new TestRandomAccessFileByChannel().updateSongName(path, songName);
        new TestRandomAccessFileByChannel().read(path);
    }
}

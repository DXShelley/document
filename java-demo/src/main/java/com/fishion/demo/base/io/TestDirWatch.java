package com.fishion.demo.base.io;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月19日 8:39
 */
public class TestDirWatch {
    public static void main(String[] args) throws IOException {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get("F:\\tmp\\demo\\file");
            dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            System.out.println("Watch Service registered for dir: " + dir.getFileName());

            while (true) {
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException ex) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    @SuppressWarnings("unchecked") WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path fileName = ev.context();

                    System.out.println(kind.name() + ": " + fileName);

                    if (kind == ENTRY_MODIFY && fileName.toString().equals("DirectoryWatchDemo.java")) {
                        System.out.println("My source file has changed!!!");
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

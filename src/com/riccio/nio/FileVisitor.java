package com.riccio.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FileVisitor extends SimpleFileVisitor<Path> {


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {


        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);
        try {
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("temporary file path = " + tempFile.toAbsolutePath());
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("**********************");
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println("VOLUME NAME/ DRIVE LETTER = " + store);
            System.out.println("file store : " + store.name());
        }

        Path dirPath = FileSystems.getDefault().getPath( "files");
        try {
            Files.walkFileTree(dirPath, new com.riccio.nio.FileVisitor());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

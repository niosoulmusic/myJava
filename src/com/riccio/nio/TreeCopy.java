package com.riccio.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class TreeCopy extends SimpleFileVisitor<Path> {

    private Path sourceRoot;
    private Path targetRoot;

    public TreeCopy(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

        Path relativizedPath = sourceRoot.relativize(dir);
        System.out.println("RelativizedPath = " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy = " + copyDir);

        try {
            Files.copy(dir, copyDir);
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println("RelativizedPath = " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy = " + copyDir);

        try {
            Files.copy(file, copyDir);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        String separator = File.separator;

        Path sourcePath = FileSystems.getDefault().getPath("files");
        try{
            Files.walkFileTree(sourcePath, new com.riccio.nio.FileVisitor());
        }catch (Exception e){
            e.printStackTrace();
        }

        Path destinationPath = FileSystems.getDefault().getPath("copyed");
        try{
            Files.walkFileTree(sourcePath,new TreeCopy(sourcePath,destinationPath));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

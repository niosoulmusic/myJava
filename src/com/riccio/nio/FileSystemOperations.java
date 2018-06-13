package com.riccio.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileSystemOperations {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("files");
        printFile(path);
        Path filePath = FileSystems.getDefault().getPath("files", "textfile2");

        printFile(filePath);
        filePath = Paths.get("/Users/euge/IdeaProjects/files/outthere.txt");
        printFile(filePath);

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

        Path relativePath = Paths.get(".", "files", "textfile2");
        printFile(relativePath);

        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "textfile2");
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2.normalize());
        Path folderPath = FileSystems.getDefault().getPath("files");
        System.out.println(Files.exists(folderPath));

        Path sourceFile = FileSystems.getDefault().getPath("files","textfile");
        Path destinationFile = FileSystems.getDefault().getPath("files", "filesCopy.txt");
        try {
            System.out.println("size = " + Files.size(destinationFile));
            System.out.println("last modified = "+Files.getLastModifiedTime(destinationFile));
            BasicFileAttributes attrs = Files.readAttributes(destinationFile,BasicFileAttributes.class);
            System.out.println("created = "+attrs.creationTime());
            System.out.println("is directory ="+attrs.isDirectory());
            System.out.println("is regular files =" +attrs.isRegularFile());

            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            Path sourceDirectory = FileSystems.getDefault().getPath("files");
            Path destinationDirectory = FileSystems.getDefault().getPath("copyed");
            Files.copy(sourceDirectory, destinationDirectory, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

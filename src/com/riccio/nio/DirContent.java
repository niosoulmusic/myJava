package com.riccio.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirContent {

    public static void main(String[] args) {
        Path directory = FileSystems.getDefault().getPath(".");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory,"*")) {
            for (Path file : contents) {
                BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                if (attrs.isRegularFile()) {
                    System.out.println(StringColors.ANSI_BLACK + file.getFileName() +
                            String.format("%1$" + (30 - file.getFileName().toString().length()) + "s", "") +
                            attrs.creationTime() + "\t" + attrs.size() + " bytes");
                } else if (attrs.isDirectory()) {
                    System.out.println(StringColors.ANSI_BLUE + file.getFileName() +
                            String.format("%1$" + (30 - file.getFileName().toString().length()) + "s", "") +
                            attrs.creationTime());

                }
            }


        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }

        //optional - filtering file
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return (Files.isRegularFile(entry));
            }
        };
        DirectoryStream.Filter<Path> lambdaFilter = p-> Files.isRegularFile(p);

        Path dirPath = FileSystems.getDefault().getPath(".");
        System.out.println("***************************");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(dirPath, lambdaFilter)){
            for (Path file : contents){
                System.out.println(file.getFileName());
            }
        }catch (IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }

    }

}

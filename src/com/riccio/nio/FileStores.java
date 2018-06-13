package com.riccio.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileStores {
    public static void main(String[] args) {
        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);
        try{
            Path tempFile = Files.createTempFile("myapp",".appext");
            System.out.println("temporary file path = " +tempFile.toAbsolutePath());
        }catch (IOException e){
            e.getMessage();
        }
        System.out.println("**********************");
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores){
            System.out.println("VOLUME NAME/ DRIVE LETTER = "+store);
            System.out.println("file store : " +store.name());
        }
    }
}

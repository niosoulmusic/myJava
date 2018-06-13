package com.riccio.nio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class MappingIoToNio {


    public static void main(String[] args) {

        //resolving paths from io to nio
        File file = new File("/file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedhPath to nio = "+convertedPath);

        File parent = new File ("/Examples");
        File resolvedFile = new File(parent,"dir/file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile= new File("/Examples","dir/file.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("/Examples");
        Path childRelativePath = Paths.get("dir/file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        //io files get working directory
        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("working direectory = "+workingDirectory.getAbsolutePath());

        //io list files as strings
        System.out.println("**************");
        File dir2File = new File(workingDirectory,"/copied");
        String[] dir2Contents = dir2File.list();
        Arrays.stream(dir2Contents).forEach(item -> System.out.println(item));
        System.out.println("**************");

        //io list files as files
        File[] dir2Files = dir2File.listFiles();
        Arrays.stream(dir2Files).forEach(item -> System.out.println(item.getName()));
    }
}

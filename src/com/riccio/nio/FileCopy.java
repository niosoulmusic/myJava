package com.riccio.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileCopy {

    public static void main(String[] args) {
        try (RandomAccessFile raFile = new RandomAccessFile("data.dat", "rwd");
             FileChannel raFileChannel = raFile.getChannel();
             RandomAccessFile raFileCopy = new RandomAccessFile("datacopy.dat", "rw")) {
            FileChannel raFileCopyChannel = raFileCopy.getChannel();
            //fileB -> get data from file A
            long numTransferred = raFileCopyChannel.transferFrom(raFileChannel, 0, raFileChannel.size());
            System.out.println("num transefferd = " + numTransferred);
            //filA -> move data to file B
            numTransferred = raFileChannel.transferTo(0,raFileChannel.size(),raFileCopyChannel);
            System.out.println("num transefferd = " + numTransferred);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

    }
}

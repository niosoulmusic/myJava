package com.riccio.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OperationsOnFile {

    public static void main(String[] args) {
        try (FileOutputStream binFile = new FileOutputStream("data.dat")) {
            FileChannel binChannel = binFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello World!".getBytes();
            byte[] outputBytes2 = "Nice to meet you ".getBytes();

            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
            buffer.flip();
            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
            FileChannel channel = ra.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            //channel.position(int3pos);

            List<String> passions = Arrays.asList("Team Working", "Studying new technologies", "java");


            //channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("inputString = "+ new String(inputString));
            System.out.println("int 1 = "+readBuffer.getInt());
            System.out.println("int 2 = "+readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString 2 = "+new String(inputString2));
            System.out.println("int 3 = "+readBuffer.getInt());


            buffer = ByteBuffer.allocate(outputBytes.length);
            buffer.put(outputBytes);
            buffer.flip();
            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was : " + numBytes);
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numbytes written was : " + numBytes);
            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numbytes written was : " + numBytes);
            ra = new RandomAccessFile("data.dat", "rwd");
            channel = ra.getChannel();
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            System.out.println("outputbytes = " + new String(outputBytes));
            if (buffer.hasArray()) {
               // System.out.println("byte buffer = " + new String(buffer.array()));

            }

            //absolute read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();

            byte[] b = new byte[outputBytes.length];
            ra.read(b);
            System.out.println(new String(b));
            long int1 = ra.readInt();
            long int2 = ra.readInt();
            System.out.println(int1);
            System.out.println(int2);
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            channel.close();
            ra.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

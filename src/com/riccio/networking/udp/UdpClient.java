package com.riccio.networking.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpClient {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter a string to be echoed from server : ");
                echoString = scanner.nextLine();
                byte[] buffer = echoString.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                datagramSocket.send(packet);

                byte[] returnBuffer = new byte[50];
                packet = new DatagramPacket(returnBuffer, returnBuffer.length);
                datagramSocket.receive(packet);
                System.out.println("Text received is : " + new String(returnBuffer, 0, packet.getLength()));

            } while (!echoString.equalsIgnoreCase("exit"));

        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}

package com.riccio.networking.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerMultiThread extends Thread {
    private Socket socket;

    public EchoServerMultiThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String echoString = input.readLine();
                System.out.println("received client input : " + echoString);
                if (echoString.equalsIgnoreCase("exit")) {
                    break;
                }

                output.println(echoString);
            }
        } catch (IOException e) {
            System.out.println("EchoServer::something went wrong : " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {

            }
        }

    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                new EchoServerMultiThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }

}

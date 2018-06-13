package com.riccio.networking.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer1Client {


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (ServerSocket serverSocket = new ServerSocket(5000)) {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client connected");
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
                    while (true){
                        String echoString = input.readLine();
                        if (echoString.equalsIgnoreCase("exit")){
                            break;
                        }
                        output.println("Echo from server : "+echoString);
                    }

                } catch (IOException e) {
                    System.out.println("Server exception on : "+e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try(Socket socket = new Socket("127.0.0.1",5000)){
                    String echoString;
                    String response;
                    BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(),true);
                    Scanner scanner = new Scanner(System.in);
                    do {
                        System.out.println("Enter String to be echoed");
                        echoString = scanner.nextLine();
                        stringToEcho.println(echoString);
                        if (!echoString.equalsIgnoreCase("exit")){
                            response=echoes.readLine();
                            System.out.println(response);
                        }
                    }while(!echoString.equalsIgnoreCase("exit"));
                }catch (IOException e){
                    System.out.println("Client error : "+e.getMessage());
                }
            }
        }).start();
    }
}

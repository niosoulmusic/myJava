package com.riccio.networking.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1",5000)){
            String echoString;
            String response;
            socket.setSoTimeout(5000);
            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Enter String to be echoed ");
                echoString = scanner.nextLine();
                stringToEcho.println(echoString);
                if (!echoString.equalsIgnoreCase("exit")){
                    response=echoes.readLine();
                    System.out.println(response);
                }
            }while(!echoString.equalsIgnoreCase("exit"));
        }catch (SocketTimeoutException e){
            System.out.println("Socket timed out");
        }catch (IOException e){
            System.out.println("Client error : "+e.getMessage());
        }
    }
}

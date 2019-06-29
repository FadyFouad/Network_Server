package com.etaTech;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8081)){
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            while (true){
                String echo = reader.readLine();
                if (echo.equals("exit")){
                    break;
                }
                writer.println(echo);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("DisConnected");
        }
    }
}

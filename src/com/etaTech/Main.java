package com.etaTech;


import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            while (true) {
//                Socket socket = serverSocket.accept();
//                System.out.println("Connected");
//                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
//                String echo = reader.readLine();
//                if (echo.equals("exit")) {
//                    break;
//                }
//                writer.println(echo + " From Server ");
                new Echoer(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("DisConnected");
        }
    }
}

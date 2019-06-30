package com.etaTech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
    private Socket socket ;

    Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            while (true){
                String echo = reader.readLine();
                if (echo.equals("exit")){
                    break;
                }
                writer.println(echo);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            try{
               socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

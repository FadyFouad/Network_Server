package com.etaTech.UDBServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(8081);
            while (true){
                byte[]buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
                socket.receive(packet);
                System.out.println("Text Received :"+new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.newcastle.gyl.network.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * SenderDemo2: Based on SenderDemo, and get data from keyboard.
 */
public class SenderDemo2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket sender = new DatagramSocket();

        /**
         * Read data from keyboard and finish by "bye"
         */
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = keyboard.readLine() ) != null){
            if (line.equals("bye")){
                break;
            }
            byte[] bytes= line.getBytes();
            DatagramPacket dataToSend = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("10.183.138.100"), 10001);
            sender.send(dataToSend);
        }
        // close sender socket
        sender.close();
    }
}

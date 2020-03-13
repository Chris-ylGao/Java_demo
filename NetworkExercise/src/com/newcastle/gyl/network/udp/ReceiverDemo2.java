package com.newcastle.gyl.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ReceiverDemo2: based on ReceiverDemo, keep receiving data.
 */
public class ReceiverDemo2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket receiver = new DatagramSocket(10001);
        while(true) {
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            receiver.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        }
    }



}

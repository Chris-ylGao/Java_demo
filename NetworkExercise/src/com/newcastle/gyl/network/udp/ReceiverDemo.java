package com.newcastle.gyl.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ReceiverDemo: simulate the receiver of udp model;
 *
 * 1. Create a DatagramSocket with port number of sender;
 * 2. Create DatagramPacket contains byte[], length (empty array, ready to receive data)
 * 3. use datagramSocket.receive(datagramPacket) to receive data
 *      3.1 getData(): create a buffer to get received data in the packet
 *      3.2 getLength(): get the actual length of data(otherwise it would be the length of byte[] defined before);
 * 4. close socket.
 */
public class ReceiverDemo {
    public static void main(String[] args) throws IOException {

        // create a socket with specified port to receive data packet
        DatagramSocket receiveSocket = new DatagramSocket(10000);

        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);

        receiveSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));

        receiveSocket.close();
    }
}

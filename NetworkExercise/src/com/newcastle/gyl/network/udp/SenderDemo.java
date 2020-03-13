package com.newcastle.gyl.network.udp;

import java.io.IOException;
import java.net.*;

/**
 * SenderDemo: simulate the sender of udp model;
 *
 * 1. Create a DatagramSocket with null parameter;
 * 2. Create DatagramPacket contains byte[], length, ip address and port
 * 3. Use Socket to send the datagram packet
 * 4. close socket.
 */
public class SenderDemo {
    public static void main(String[] args) throws IOException {
        // DatagramSocket(int port): create a socket
        DatagramSocket sendSocket = new DatagramSocket();


        // DatagramPacket(byte[], length, ipAddress, port): create datagram packet to  be sent
        //InetAddress.getByName(String name): get ipAddress by name
        byte[] bytes = "Hello world to use udp".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("10.183.138.100"),10000);

        // send data packet by socket
        sendSocket.send(datagramPacket);

        sendSocket.close();
    }

}

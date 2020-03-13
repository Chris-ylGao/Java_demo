package com.newcastle.gyl.network.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Similar to ServerDemo2, but create thread for each client socket.
 */
public class ServerDemo3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10011);
        while(true) {
            Socket socket = serverSocket.accept();
            new Thread(new ServerThread(socket)).start();
        }
    }

}

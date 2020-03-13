package com.newcastle.gyl.network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Based on the ServerDemo, read multiple lines, and print them on the console;
 */
public class ServerDemo1 {
    public static void main(String[] args) throws IOException {
        //ClientDemo1
        //ServerSocket serverSocket = new ServerSocket(10010);
        //ClientDemo2
        ServerSocket serverSocket = new ServerSocket(10011);

        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        serverSocket.close();
    }
}

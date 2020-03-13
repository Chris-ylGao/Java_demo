package com.newcastle.gyl.network.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // ClientDemo
        ServerSocket serverSocket = new ServerSocket(10086);

        Socket s = serverSocket.accept();

        InputStream in = s.getInputStream();
        byte[] bytes = new byte[1024];
        //read(byte[]): Reads some number of bytes from the input stream and store them in the byte[]
        int length = in.read(bytes);
        System.out.println(new String(bytes,0,length));


        serverSocket.close();

    }


}

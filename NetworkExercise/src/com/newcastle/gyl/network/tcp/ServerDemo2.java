package com.newcastle.gyl.network.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Based on ServerDemo1, but write message to the file;
 *  * combined with ClientDemo1, can store input from keyboard.
 *  * combined with ClientDemo2, can upload file from client to server.
 */
public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        //ClientDemo1
        ServerSocket server = new ServerSocket(10010);
        //ClientDemo2
        //ServerSocket server = new ServerSocket(10011);
        Socket socket = server.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter file = new BufferedWriter(new FileWriter("output"));
        String line;

        while((line = br.readLine())!=null){
            file.write(line);
            file.newLine();
            file.flush();
        }

        file.close();
        server.close();

    }
}

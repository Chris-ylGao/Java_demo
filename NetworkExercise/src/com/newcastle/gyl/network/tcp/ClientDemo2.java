package com.newcastle.gyl.network.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Based on ClientDemo1, but get input from file
 */
public class ClientDemo2 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("10.183.138.100",10011);

        BufferedReader file = new BufferedReader(new FileReader("input"));
        BufferedWriter in = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String line;

        while((line = file.readLine())!=null){
            in.write(line);
            in.newLine();
            in.flush();
        }
        // Disables the output stream for this socket when the file has been transferred.
        client.shutdownOutput();

        file.close();
        client.close();
    }

}

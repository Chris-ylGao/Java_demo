package com.newcastle.gyl.network.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Based on the ClientDemo, get input message from keyboard and deliver as String Stream;
 */
public class ClientDemo1 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("10.183.138.100",10010);

        // read input from keyboard
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        // encapsulation input message as BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String line;

        while((line = keyboard.readLine())!=null){
            if (line.equals("bye")){
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        client.close();
    }

}

package com.newcastle.gyl.network.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
/**
 * ClientDemo: Simulate client Socket of TCP model(Send predefined message)
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("10.183.138.100", 10086);

        // create an outputStream for client socket
        OutputStream out = clientSocket.getOutputStream();
        out.write("hello world".getBytes());

        clientSocket.close();
    }
}

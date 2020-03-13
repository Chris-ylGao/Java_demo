package com.newcastle.gyl.network.tcp;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            File file = new File("output");
            int count = 1;
            while(file.exists()) {
                file = new File("output(" +count + ")");
                count++;
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String line;
            while((line = br.readLine())!=null){
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            bw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

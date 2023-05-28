package com.company;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatReceive implements Runnable {
    private final Socket socket;
    private BufferedReader in;

    public ChatReceive(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            String command = "";
            try {
                if (in != null)
                    command = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(command);
        }
    }
}


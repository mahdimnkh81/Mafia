package com.company;





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatSender implements Runnable {
    private final Socket socket;

    private PrintWriter out;
    private BufferedReader in;

    public ChatSender(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                String command = in.readLine();
                out.println( " : " + command);
                System.out.println("Sent " + " : " + command);
                if (command.equalsIgnoreCase("READY") || in == null)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


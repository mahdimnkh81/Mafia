package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class CLIENT {




    public static void main(String[] args) throws IOException {




        String serverHostname = new String ("127.0.0.1");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {


            echoSocket = new Socket("127.0.0.1", 4799);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

            Thread t2 = new Thread(new ClientTask6(echoSocket,out,in));
            t2.start();
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + serverHostname);
            System.exit(1);
        }


    }
}


class ClientTask4 implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public ClientTask4(Socket clientSocket, PrintWriter out, BufferedReader in) {
        this.clientSocket = clientSocket;
        this.out = out;
        this.in = in;
    }
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

    public void run() {



        while (true){
            String userInput = null;

            System.out.println("Type Message (\"exit\" to quit)");
            while (true) {
                try {
                    if (!((userInput = stdIn.readLine()) != null))
                        break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out.println(userInput);

                if (userInput.equals("Finish my talking")) {

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


//        out.close();
//        in.close();
//        stdIn.close();
//        echoSocket.close();
            }

        }}
}


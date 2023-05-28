package com.company;

import java.net.*;
import java.io.*;
import java.util.*;

class server extends Thread {

    public static ArrayList<String> num = new ArrayList<>();
    public static ArrayList<Socket> sockets = new ArrayList<>();
    //String[] nam= new String[]{"ALI", "MAHDI", "REZA"};
    String v;
    static int Die_hard = 0;
    static int Die_hard_Alive = 0;
    static int number = 0;
    static int flag2 = 0;
    static int LECTOR = 0;
    static int Doctor_shahr = 0;
    static int bound = 10;
    static int limit = 10;
    static int i = 0;
    static int flag = 0;
    static int flag3 = 0;
    static String voting1;
    static String voting2;
    static String voting3;
    static String voting4;
    static HashMap<String, Integer> vote = new HashMap<>();
    static HashMap<String, String> person = new HashMap<String, String>();
    static HashMap<SocketAddress, Socket> PAK = new HashMap<SocketAddress, Socket>();
    static HashMap<SocketAddress, String> PAK2 = new HashMap<SocketAddress, String>();
    static HashMap<String, Socket> delet = new HashMap<String, Socket>();
    static ArrayList<Socket> SSockets = new ArrayList<>();
    String ClientIP = null;
    static Socket clientSocket;
    ;
    static String response;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Thread> ThreadALL = new ArrayList<>();


        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(4799);
            System.out.println("Connection Socket Created");
            System.out.println("Enter name");
            String p =scanner.nextLine();
            num.add(p);
            try {
                while (true) {
                    System.out.println("Waiting for Connection");
                    Thread t1 = new Thread(new server(serverSocket.accept()));
                    ThreadALL.add(t1);
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: 9797.");
            System.exit(1);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Could not close port: 9797");
                System.exit(1);
            }
        }
    }


    public server(Socket clientSoc) {

        for (int j = 0; j < num.size(); j++) {
            vote.put(num.get(j), 0);

        }
        clientSocket = clientSoc;
        sockets.add(clientSocket);
        SSockets.add(clientSocket);
        delet.put(num.get(i), clientSocket);
        ClientIP = clientSocket.getRemoteSocketAddress().toString();
        SocketAddress ClientIP2 = clientSocket.getRemoteSocketAddress();
        person.put(ClientIP, num.get(i));
        PAK.put(ClientIP2, clientSocket);
        PAK2.put(ClientIP2, num.get(i));
        i++;
        start();
    }

    public void run() {

        if (SSockets.size() == 10) {


                System.out.println("Mafias wake up");
                System.out.println(num.get(1) + " : " + "SIMPLE_MAFIA");
                System.out.println(num.get(0) + " : " + "DOCTORLECTOR");
                System.out.println("Mafias sleep");
                System.out.flush();
                try {
                    sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Doctor_Shar wake up");
                System.out.println(num.get(3) + " : " + "Doctor_Shar");
                System.out.println("Doctor_Shar sleep");
                System.out.flush();
                try {
                    sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Work_SHOP wake up");
                System.out.println(num.get(4) + " : " + "Work_Shop");
                System.out.println("Work_SHOP sleep");
                try {
                    sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("professional wake up");
                System.out.println(num.get(5) + " : " + "professional");
                System.out.println("professional sleep");
                try {
                    sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Die_hard wake up");
                System.out.println(num.get(6) + " : " + "Die_hard");
                System.out.println("Die_hard sleep");
                try {
                    sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }





            int temp;

            Scanner scanner = new Scanner(System.in);
            ArrayList<Integer> Moghayeseh = new ArrayList<>();


            while (true) {

                if (flag == 1) {


                    try {
                        String inputLine;


                        while (true) {


                            if (!(SSockets.get(0).isInputShutdown())) {
                                BufferedReader in1 = new BufferedReader(new InputStreamReader(SSockets.get(0).getInputStream()));
                                while (true) {
                                    if (!((inputLine = in1.readLine()) != null))
                                        break;

                                    System.out.println(num.get(0) + ": " + inputLine);
                                    if (inputLine.equals("F")) {
                                        System.out.println("Who are you suspicious of");
                                        number++;
                                        String name = in1.readLine();
                                        System.out.println(num.get(0) + ": " + name);
                                        if (server.vote.containsKey(name)) {
                                            int a = server.vote.get(name);
                                            server.vote.replace(name, a, a + 1);
                                            Thread.sleep(1);

                                        }
                                    }
                                    break;
                                }
                            }
                            if (!(SSockets.get(1).isInputShutdown())) {
                                BufferedReader in2 = new BufferedReader(new InputStreamReader(SSockets.get(1).getInputStream()));

                                while (true) {
                                    if (!((inputLine = in2.readLine()) != null))
                                        break;
                                    System.out.println(num.get(1) + ": " + inputLine);
                                    if (inputLine.equals("F")) {
                                        System.out.println("Who are you suspicious of");
                                        number++;
                                        String name = in2.readLine();
                                        System.out.println(num.get(1) + ": " + name);
                                        if (server.vote.containsKey(name)) {
                                            int a = server.vote.get(name);
                                            server.vote.replace(name, a, a + 1);
                                            Thread.sleep(1);


                                        }
                                    }
                                    break;
                                }
                            }
                            if (!(SSockets.get(2).isInputShutdown())) {
                                BufferedReader in3 = new BufferedReader(new InputStreamReader(SSockets.get(2).getInputStream()));

                                while (true) {
                                    if (!((inputLine = in3.readLine()) != null))
                                        break;
                                    System.out.println(num.get(2) + ": " + inputLine);
                                    if (inputLine.equals("F")) {
                                        System.out.println("Who are you suspicious of");
                                        number++;
                                        String name = in3.readLine();
                                        System.out.println(num.get(2) + ": " + name);
                                        if (server.vote.containsKey(name)) {
                                            int a = server.vote.get(name);
                                            server.vote.replace(name, a, a + 1);
                                            Thread.sleep(1);
                                        }
                                    }
                                    break;
                                }
                            }
                            if (!(SSockets.get(3).isInputShutdown())) {
                                BufferedReader in4 = new BufferedReader(new InputStreamReader(SSockets.get(3).getInputStream()));

                                while (true) {
                                    if (!((inputLine = in4.readLine()) != null))
                                        break;
                                    System.out.println(num.get(3) + ": " + inputLine);
                                    if (inputLine.equals("F")) {
                                        System.out.println("Who are you suspicious of");
                                        number++;
                                        String name = in4.readLine();
                                        System.out.println(num.get(3) + ": " + name);
                                        if (server.vote.containsKey(name)) {
                                            int a = server.vote.get(name);
                                            server.vote.replace(name, a, a + 1);
                                            Thread.sleep(1);


                                        }
                                    }
                                    break;
                                }
                            }
                            if (!(SSockets.get(4).isInputShutdown())) {
                                BufferedReader in5 = new BufferedReader(new InputStreamReader(SSockets.get(4).getInputStream()));

                                while (true) {
                                    if (!((inputLine = in5.readLine()) != null))
                                        break;
                                    System.out.println(num.get(4) + ": " + inputLine);
                                    if (inputLine.equals("F")) {
                                        System.out.println("Who are you suspicious of");
                                        number++;
                                        String name = in5.readLine();
                                        System.out.println(num.get(4) + ": " + name);
                                        if (server.vote.containsKey(name)) {
                                            int a = server.vote.get(name);
                                            server.vote.replace(name, a, a + 1);
                                            Thread.sleep(1);


                                        }
                                    }
                                    break;
                                }
                            }
                            if (!(SSockets.get(5).isInputShutdown())) {
                                BufferedReader in6 = new BufferedReader(new InputStreamReader(SSockets.get(5).getInputStream()));

                                while (true) {
                                    if (!((inputLine = in6.readLine()) != null))
                                        break;
                                    System.out.println(num.get(5) + ": " + inputLine);
                                    if (inputLine.equals("F")) {
                                        System.out.println("Who are you suspicious of");
                                        number++;
                                        String name = in6.readLine();
                                        System.out.println(num.get(5) + ": " + name);
                                        if (server.vote.containsKey(name)) {
                                            int a = server.vote.get(name);
                                            server.vote.replace(name, a, a + 1);
                                            Thread.sleep(1);


                                        }
                                    }
                                    break;
                                }
                            }
                            if (!(SSockets.get(6).isInputShutdown())) {
                                BufferedReader in7 = new BufferedReader(new InputStreamReader(SSockets.get(6).getInputStream()));

                                while (true) {
                                    if (!((inputLine = in7.readLine()) != null))
                                        break;
                                    System.out.println(num.get(6) + ": " + inputLine);
                                    if (inputLine.equals("F")) {
                                        System.out.println("Who are you suspicious of");
                                        number++;
                                        String name = in7.readLine();
                                        System.out.println(num.get(6) + ": " + name);
                                        if (server.vote.containsKey(name)) {
                                            int a = server.vote.get(name);
                                            server.vote.replace(name, a, a + 1);
                                            Thread.sleep(1);


                                        }
                                    }
                                    break;
                                }
                            }
                            if (!(SSockets.get(7).isInputShutdown())) {
                                BufferedReader in8 = new BufferedReader(new InputStreamReader(SSockets.get(7).getInputStream()));

                                while (true) {
                                    if (!((inputLine = in8.readLine()) != null))
                                        break;
                                    System.out.println(num.get(7) + ": " + inputLine);
                                    if (inputLine.equals("F")) {
                                        System.out.println("Who are you suspicious of");
                                        number++;
                                        String name = in8.readLine();
                                        System.out.println(num.get(7) + ": " + name);
                                        if (server.vote.containsKey(name)) {
                                            int a = server.vote.get(name);
                                            server.vote.replace(name, a, a + 1);
                                            Thread.sleep(1);


                                        }
                                    }
                                    break;
                                }
                            }
                            if ((SSockets.get(0).isInputShutdown())) {
                                limit--;
                            }
                            if ((SSockets.get(1).isInputShutdown())) {
                                limit--;
                            }
                            if ((SSockets.get(2).isInputShutdown())) {
                                limit--;
                            }
                            if ((SSockets.get(3).isInputShutdown())) {
                                limit--;
                            }
                            if ((SSockets.get(4).isInputShutdown())) {
                                limit--;
                            }
                            if ((SSockets.get(5).isInputShutdown())) {
                                limit--;
                            }
                            if ((SSockets.get(6).isInputShutdown())) {
                                limit--;
                            }
                            if ((SSockets.get(7).isInputShutdown())) {
                                limit--;
                            }


                            if (number == limit) {
                                break;
                            }

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    System.out.println("]]]]]]]");


                    if (number == bound) {
                        System.out.println("****");
                        for (int k = 0; k < num.size(); k++) {

                            String u = num.get(k);
                            Moghayeseh.add(server.vote.get(u));


                        }

                        for (int i = 0; i < Moghayeseh.size(); i++) {
                            for (int j = i + 1; j < Moghayeseh.size(); j++) {
                                if (Moghayeseh.get(i) < Moghayeseh.get(j)) {
                                    temp = Moghayeseh.get(i);
                                    Moghayeseh.set(i, Moghayeseh.get(j));
                                    Moghayeseh.set(j, temp);
                                }
                            }
                        }


                        for (Map.Entry<String, Integer> entry : server.vote.entrySet()) {
                            if (entry.getValue().equals(Moghayeseh.get(0))) {
                                v = entry.getKey();
                            }
                        }

                        SocketAddress J = null;
                        for (Map.Entry<SocketAddress, String> entry : server.PAK2.entrySet()) {
                            if (entry.getValue().equals(v)) {
                                J = entry.getKey();
                            }
                        }

                        for (int j = 0; j < sockets.size(); j++) {
                            SocketAddress x = sockets.get(j).getRemoteSocketAddress();
                            String xx = x.toString();
                            String JJ = J.toString();
                            if (xx.equals(JJ)) {
                                if (flag2 == 1 || SSockets.get(7).isInputShutdown()) {
                                    try {
                                        SSockets.get(j).shutdownOutput();
                                        SSockets.get(j).shutdownInput();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    System.out.println("Someone left the game ");
                                    break;
                                }

                                while (flag2 == 0) {

                                    try {
                                        if (!(SSockets.get(7).isInputShutdown())) {
                                            while (true) {
                                                try {
                                                    System.out.println("Shdar Do you want the vote to be canceled?");
                                                    BufferedReader in8 = new BufferedReader(new InputStreamReader(SSockets.get(7).getInputStream()));
                                                    while (true) {
                                                        String inputLine;
                                                        if (!((inputLine = in8.readLine()) != null))
                                                            break;
                                                        System.out.println("$$$" + ": " + inputLine);
                                                        if (inputLine.equals("yes")) {
                                                            flag2 = 1;
                                                            System.out.println("This round of voting canceled");
                                                            bound++;
                                                            break;
                                                        }

                                                        if (inputLine.equals("no")) {
                                                            SSockets.get(j).shutdownOutput();
                                                            SSockets.get(j).shutdownInput();
                                                            System.out.println("Someone left the game");
                                                            break;
                                                        }

                                                    }
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            }
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                }
                            }
                        }
                        System.out.println("45");
                        bound--;
                        number = 0;
                        flag = 0;

                    }

                }


                if (flag == 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("SHABBBBBB");


                        //********************* while for Mafia *************************


                        try {

                            int m = 0;

                            // *************************** doctor lector *********************
                            if (!(SSockets.get(0).isInputShutdown())) {
                                System.out.println("Doctor lector wake up");
                                BufferedReader in5 = new BufferedReader(new InputStreamReader(sockets.get(0).getInputStream()));
                                while (m == 0) {
                                    try {
                                        m = 1;
                                        System.out.println("Doctor lector Which mafias do you want to protect?");
                                        while ((response = in5.readLine()) != null) {
                                            System.out.println(num.get(0) + ": " + response);
                                            voting1 = response;
                                            if (response.equals("myself") && LECTOR == 0) {
                                                voting1 = num.get(0);
                                                LECTOR = 1;
                                                break;
                                            } else {
                                                if (response.equals("myself")) {
                                                    System.out.println("You saved yourself once before");
                                                    System.out.println("Save another person, say his name");
                                                    response = in5.readLine();
                                                    voting1 = response;
                                                    break;
                                                } else {
                                                    voting1 = response;
                                                    break;
                                                }
                                            }

                                        }

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }


                                try {
                                    in5.mark(2);
                                    in5.reset();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

//                String response9 = null;
//                            System.out.println("What do Doctor lector suggest for God_Father?");
//                            while (true) {
//                                try {
//                                    if (!((response9 = in5.readLine()) != null)) break;
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                                System.out.println(num.get(0) + ": " + response9);
//                                System.out.println("..........");
//                                System.out.println(response9);
//                                if (response9.equals("FI")) {
//                                    System.out.println("+++");
//                                    break;
//                                }
//                            }


                            //************************* mafia simple *******************************
                            if (!(SSockets.get(1).isInputShutdown())) {
                                System.out.println("Mafia_Simple wake up");
                                BufferedReader in3 = new BufferedReader(new InputStreamReader(sockets.get(1).getInputStream()));
                                System.out.println("What do mafia simple suggest for God_Father?");
                                String response7;
                                while (true) {
                                    try {

                                        while ((response = in3.readLine()) != null) {
                                            System.out.println(num.get(1) + ": " + response);
                                            if (response.equals("FI")) {
                                                break;
                                            }
                                        }

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                }

                            }
                            //******************************** God_father **************************************
                            if (!(SSockets.get(2).isInputShutdown())) {
                                System.out.println("GOD_FATHER wake up");
                                BufferedReader in4 = new BufferedReader(new InputStreamReader(sockets.get(2).getInputStream()));
                                SocketAddress B1 = null;
                                //*****ALIVE GOD_FATHER***********
                                for (Map.Entry<SocketAddress, String> entry : PAK2.entrySet()) {
                                    if (entry.getValue().equals(num.get(2))) {
                                        B1 = entry.getKey();
                                    }
                                }
                                Socket B2 = PAK.get(B1);


                                System.out.println("Who do you want to kill God_Father?");
                                String response3;
                                while (true) {
                                    try {
                                        while ((response = in4.readLine()) != null) {
                                            System.out.println(num.get(2) + ": " + response);
                                            voting3 = response;
                                            break;

                                        }

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                }
                            }

                            // ***************** if God_Father Dead ************************
                            if (SSockets.get(2).isInputShutdown()) {
                                BufferedReader in6 = new BufferedReader(new InputStreamReader(sockets.get(2).getInputStream()));
                                String response8;
                                if (SSockets.get(2).isInputShutdown()) {
                                    System.out.println("Dead Ali, you are his successor, who do you want to kill");
                                    while (true) {
                                        try {
                                            while ((response8 = in6.readLine()) != null) {
                                                System.out.println(num.get(0) + ": " + response8);
                                                voting2 = response8;
                                                break;
                                            }

                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                    }

                                }
                            }

                            //************************************ Doctor shahr **************************************
                            if (!(SSockets.get(3).isInputShutdown())) {
                                System.out.println("Doctor Shahr wake up");
                                BufferedReader in7 = null;
                                try {
                                    in7 = new BufferedReader(new InputStreamReader(sockets.get(3).getInputStream()));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                String response88;
                                while (true) {
                                    try {
                                        System.out.println("Who do you want to save?");
                                        while ((response88 = in7.readLine()) != null) {
                                            System.out.println(num.get(3) + ": " + response88);
                                            voting2 = response88;
                                            if (voting2.equals("myself") && Doctor_shahr == 0) {
                                                voting2 = num.get(3);
                                                Doctor_shahr = 1;
                                                break;
                                            } else {
                                                if (response88.equals("myself")) {
                                                    System.out.println("You saved yourself once before");
                                                    System.out.println("Save another person, say his name");
                                                    response88 = in7.readLine();
                                                    voting2 = response88;
                                                    break;
                                                } else {
                                                    voting2 = response88;
                                                    break;
                                                }
                                            }

                                        }

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                }
                            }

                            //*************************** Workshop **********************************
                            if (!(SSockets.get(4).isInputShutdown())) {
                                System.out.println("Work_shop wake up");
                                BufferedReader in8 = null;
                                try {
                                    in8 = new BufferedReader(new InputStreamReader(SSockets.get(4).getInputStream()));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                String response99;
                                while (true) {
                                    try {
                                        System.out.println("Who do you want to inquire about?");
                                        while ((response99 = in8.readLine()) != null) {
                                            System.out.println(num.get(4) + ": " + response99);
                                            if (response99.equals(num.get(0)) || response99.equals(num.get(1))) {
                                                if (response99.equals(num.get(0))) {
                                                    System.out.println("He is a doctor_lector");
                                                    break;
                                                }
                                                if (response99.equals(num.get(1))) {
                                                    System.out.println("He is a Mafia_simple");
                                                    break;
                                                }
                                            } else {
                                                System.out.println("I can not confirm");
                                                break;
                                            }

                                            break;
                                        }


                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                }

                            }
                            //******************************* professional *******************************
                            if (!(SSockets.get(5).isInputShutdown())) {
                                System.out.println("professional wake up");

                                try {
                                    BufferedReader in9 = new BufferedReader(new InputStreamReader(SSockets.get(5).getInputStream()));
                                    String response10;
                                    while (true) {
                                        try {

                                            System.out.println("Are you suspicious of anyone? Do you want to kill someone?");
                                            while ((response10 = in9.readLine()) != null) {
                                                System.out.println(num.get(5) + ": " + response10);
                                                if (response10.equals("yes")) {
                                                    System.out.println("Who do you want to kill?");
                                                    response10 = in9.readLine();
                                                    if (num.get(0).equals(response10) || response10.equals(num.get(1))) {
                                                        voting4 = response10;
                                                        break;
                                                    } else {
                                                        SSockets.get(5).shutdownOutput();
                                                        SSockets.get(5).shutdownInput();
                                                        break;
                                                    }
                                                }
                                                if (response10.equals("no")) {
                                                    break;
                                                }


                                            }


                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
//                //************************* Psychologist ************************************
//
//                System.out.println("Psychologist wake up");
//                BufferedReader in19 = null;
//                try {
//                    in19 = new BufferedReader(new InputStreamReader(sockets.get(2).getInputStream()));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                String response11;
//                while (true) {
//                    try {
//                        System.out.println("Do you want to silence someone?");
//                        System.out.println("If yes, say his name");
//                        response11 = in19.readLine();
//                        System.out.println(num.get(2) + "++++ " + response11);
//                        flag = 1;
//                        break;
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//                    System.out.println(666);
//                    break;


                            //*********************************** Die-hard **************************************
                            if (!(SSockets.get(6).isInputShutdown())) {
                                System.out.println("Die-hard wake up");
                                BufferedReader in10 = null;
                                try {
                                    in10 = new BufferedReader(new InputStreamReader(SSockets.get(6).getInputStream()));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                String response11;
                                while (true) {
                                    try {
                                        if (Die_hard < 2) {
                                            System.out.println("Do you want to use your role?");
                                            while ((response11 = in10.readLine()) != null) {
                                                System.out.println(num.get(6) + ": " + response11);
                                                System.out.println(response11);
                                                if (response11.equals("yes") && Die_hard < 3) {
                                                    Die_hard++;
                                                    if (!(SSockets.get(0).isInputShutdown())) {
                                                        System.out.println("The doctor Lector is alive");
                                                    }
                                                    if (!(SSockets.get(1).isInputShutdown())) {
                                                        System.out.println("The simple Mafia is alive");
                                                    }
                                                    if (!(SSockets.get(2).isInputShutdown())) {
                                                        System.out.println("The God_Father is alive");
                                                    }
                                                    if (!(SSockets.get(3).isInputShutdown())) {
                                                        System.out.println("The Shahdar is alive");
                                                    }
                                                    if (!(SSockets.get(4).isInputShutdown())) {
                                                        System.out.println("The doctor_Shar is alive");
                                                    }
                                                    if (!(SSockets.get(5).isInputShutdown())) {
                                                        System.out.println("The Work_Shop is alive");
                                                    }
                                                    if (!(SSockets.get(7).isInputShutdown())) {
                                                        System.out.println("The professional is alive");
                                                    }

                                                }
                                                if (response11.equals("no")) {
                                                    break;
                                                }


                                                break;
                                            }


                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                }

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        // GOD_FATHER VS DOCTOR_SHAR
                        if (voting2.equals(voting3)) {
                            System.out.println("Gad_Father could not kill anyone because the doctor of the city saved that person");
                        }
                        if (!(voting2.equals(voting3))) {
                            System.out.println("Someone left the game");
                            try {
                                delet.get(voting3).shutdownInput();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        // GOD_FATHER VS Die-hard
                        if (voting3.equals(num.get(6))) {
                            if (Die_hard_Alive < 2) {
                                System.out.println("Die-hard was not killed");
                            }
                            if (Die_hard_Alive >= 2) {
                                try {
                                    SSockets.get(6).shutdownInput();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            Die_hard_Alive++;
                        }

                        // GOD_FATHER VS professional
                        if (voting4.equals(voting1)) {
                            System.out.println("professional could not kill anyone because the doctor lector  saved that person");
                        }
                        if (!(voting4.equals(voting1))) {
                            try {
                                delet.get(voting4).getInputStream();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Someone left the game");
                        }


                }
            }

        }

    }
}



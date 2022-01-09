package com.pb.trojno.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CLient {
    public static void main(String[] args) throws Exception{
        String serverIp = "127.0.0.1";
        int serverPort = 9234;

        Socket server = new Socket(serverIp, serverPort);
        System.out.println("Клиент стартовал");
        BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);
        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

        String dataFromUser, dataFromServer;

        // Основной цикл отправки сообщений серверу
        while ((dataFromUser = inConsole.readLine()) != null) {
            outServer.println(dataFromUser); //println(dataFromUser);
            outServer.flush();
            dataFromServer = inServer.readLine();
            System.out.println("Сообщение от сервера " + dataFromServer);
            if ("exit".equalsIgnoreCase(dataFromUser)) {
                break;
            }
        }
        outServer.close();
        inServer.close();
        outServer.close();
        server.close();

    }
}

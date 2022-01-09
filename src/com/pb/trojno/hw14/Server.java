package com.pb.trojno.hw14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run(){
            try {

                System.out.println(Thread.currentThread().getName() + ": Получен запрос от клиента");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

                String input,output;

                // цикл ожидания сообщений от клиента
                System.out.println("Ожидаем сообщений");
                while ((input = in.readLine()) != null) {
                    if (input.equalsIgnoreCase("exit"))
                        break;

                    System.out.println(this.name + ": " + input);
                    out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss")).toString() + " " + input);

                }

                System.out.println("Client disconnected");

                out.close();
                in.close();

                System.out.println("Close stream");

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception ex) {}
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int port = 9234;
        ServerSocket serversocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while(true){
            Socket clientSocket = serversocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}

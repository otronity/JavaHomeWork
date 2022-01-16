package com.pb.trojno.hw14;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CLient extends Application {

    public static void main(String[] args) throws Exception{
        Application.launch(args);
    }

    @Override
    public void start (Stage stage) throws Exception{

        Label label = new Label("Enter message:");
        TextField msgField = new TextField();
        TextArea srvMess = new TextArea();
        Button sendBtn = new Button("send message");
        Button exitBtn = new Button("EXIT");

        String serverIp = "127.0.0.1";
        int serverPort = 9234;

        Socket server = new Socket(serverIp, serverPort);

        BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);

        sendBtn.setOnAction(e -> {
            try {
                String dataFromUser, dataFromServer;
                dataFromUser = msgField.getText();
                msgField.clear();
                outServer.println(dataFromUser);
                outServer.flush();
                dataFromServer = inServer.readLine();
                if (dataFromServer.trim().length() > 0) {
                    srvMess.appendText(dataFromServer + '\n');
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        exitBtn.setOnAction(e -> {
            Platform.exit();
            try {
                inServer.close();
                outServer.close();
                server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        VBox root = new VBox();
        root.setSpacing(6);
        root.getChildren().addAll(label, msgField, srvMess, sendBtn, exitBtn);
        Scene scene = new Scene(root, 350, 350);
        stage.setScene(scene);
        stage.setTitle("Chat Client");
        stage.show();

    }
}

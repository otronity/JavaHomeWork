package com.pb.trojno.hw9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileNumbers {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(FileNumbers.class.getName());
        logger.log(Level.INFO, "Start programm!");
        createNumbersFile();
        createOddNumbersFile();
        logger.log(Level.INFO, "End programm!");
    }

    static void createNumbersFile (){

        Logger logger = Logger.getLogger(FileNumbers.class.getName());
        logger.log(Level.INFO, "Create file numbers.txt!");
        try {
            Files.deleteIfExists(Paths.get("C:\\Users\\Admin\\Desktop\\numbers.txt"));
            Path crFile = Files.createFile(Paths.get("C:\\Users\\Admin\\Desktop\\numbers.txt"));
        } catch (Exception e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
            e.getStackTrace();
            logger.log(Level.WARNING, "Cannot create file numbers.txt!!!!");
        }

        logger.log(Level.INFO, "Input data to file numbers.txt!");
        Path path = Paths.get("C:\\Users\\Admin\\Desktop\\numbers.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            Random random = new Random();
            for (int i=1; i<=10; i++) {
                for (int ii=1; ii<=10; ii++){
                    int x = random.nextInt(100);
                    writer.write(x + " " );
                }
                writer.newLine();
            }
            System.out.println("Файл " + path + " создан!");
        } catch (Exception e) {System.out.println("Ошибка " + e.getMessage()); e.getStackTrace();
            logger.log(Level.WARNING, "Cannot input data to file numbers.txt!!!!");}

    };

    static void createOddNumbersFile (){
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Admin\\Desktop\\numbers.txt"))){
            Files.deleteIfExists(Paths.get("C:\\Users\\Admin\\Desktop\\odd-numbers.txt"));
            Path crFile = Files.createFile(Paths.get("C:\\Users\\Admin\\Desktop\\odd-numbers.txt"));
            Path path = Paths.get("C:\\Users\\Admin\\Desktop\\odd-numbers.txt");
            String line;
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            while((line = reader.readLine()) != null) {
                Scanner scan = new Scanner(line);
                scan.useDelimiter(" ");
                String s = "";
                int num;
                while (scan.hasNext()) {
                    num = scan.nextInt();
                    if ((num % 2) == 0) {
                        s = s + "0 ";
                    } else s = s + num + " ";
                }
                writer.write(s);
                writer.newLine();
            }
            } catch (Exception e) {System.out.println("Ошибка " + e.getMessage()); e.getStackTrace();}
            System.out.println("Файл " + path + " создан!");
        } catch (Exception e) {System.out.println("Ошибка " + e.getMessage()); e.getStackTrace();}


    };
}


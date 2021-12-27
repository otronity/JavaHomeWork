package com.pb.trojno.hw13;

import java.util.LinkedList;
import java.util.Random;

public class Main {

    static class Reader implements Runnable{

        private final LinkedList list;

        public Reader(LinkedList list) {
            this.list = list;
        }

        public void run() {
            while (true) {
                try {
                    synchronized (list) {
                        if (!list.isEmpty()) {
                            System.out.println("Читаем из списка " + list.toString() + " первое значение " + list.getFirst());
                            list.pollFirst();
                            list.notify();
                        } else {
                            System.out.println("Список пуст!");
                            list.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    static class Writer implements Runnable{
        private LinkedList list;

        public Writer(LinkedList list){
            this.list = list;
        }

        public void run(){
            while(true) {
                try {
                    int x = new Random().nextInt(5);
                    synchronized (list) {
                        if (list.size() < 5) {
                            list.add(list.size(), x);
                            System.out.println("Пишем значение в список " + list.toString());
                            list.notify();
                        } else {
                            System.out.println("Список полностью заполнен!");
                            list.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        Thread writer = new Thread(new Writer(list));
        Thread reader = new Thread(new Reader(list));

        writer.start();
        reader.start();

    }
}

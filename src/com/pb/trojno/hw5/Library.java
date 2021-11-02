package com.pb.trojno.hw5;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Приключения", "Иванов И. И.", 2000);
        Book book2 = new Book("Словарь", "Сидоров А. В.", 1980);
        Book book3 = new Book("Энциклопедия", "Гусев К. В.", 2010);

        Reader reader1 = new Reader("Петров В. В.", 1, "Экономика", "02.05.1990", "0502562535");
        Reader reader2 = new Reader("Тройно О. Л.", 2, "Финансы", "02.05.1985", "0952549642");
        Reader reader3 = new Reader("Щаповал Н. Г.", 3, "Финансы", "28.11.1992", "0630213289");

        System.out.println("Книги:");
        book1.getInfo();
        book2.getInfo();
        book3.getInfo();

        System.out.println();
        System.out.println("Читатели:");
        reader1.getInfo();
        reader2.getInfo();
        reader3.getInfo();

        System.out.println();
        System.out.println("Кто сколько/какие книги взял");
        reader1.takeBook(3);
        reader2.takeBook(book1.getName(), book2.getName(), book3.getName());
        reader1.takeBook(book1, book2);
        reader3.takeBook(book1.getName(), book3.getName());

        System.out.println();
        System.out.println("Кто сколько/какие книги вернул");
        reader1.returnBook(2);
        reader2.returnBook(book3.getName(), book2.getName(), book1.getName());
        reader1.returnBook(book3, book2);
        reader3.returnBook(book1, book3);

    }
}

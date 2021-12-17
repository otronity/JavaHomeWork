package com.pb.trojno.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<PhoneBook> phoneList = new ArrayList<>();

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new DateSerializer());
        module.addDeserializer(LocalDateTime.class, new DateDeserializer());
        mapper.registerModule(module);

        phoneList.add(new PhoneBook("Соник Петр",
                                "19.12.2008",
                                        Arrays.asList("09567892451", "0563248957"),
                                 "Щолохова 3",
                                    LocalDateTime.now()
                                    ));
        phoneList.add(new PhoneBook("Беннет Лидия",
                "19.12.1980",
                Arrays.asList("0502494957"),
                "Жолудева 13",
                LocalDateTime.now()
        ));

        phoneList.add(new PhoneBook("Транч Сидни",
                "19.12.2000",
                Arrays.asList("0682354986"),
                "Кропивная 78",
                LocalDateTime.now()
        ));

        System.out.println("Начальный список:");
        System.out.println(phoneList.toString().toString());

        phoneList.sort(Comparator.comparing(p -> p.birthDate));
        System.out.println("Список после сортировки по Днюю рождения:");
        System.out.println(phoneList.toString().toString());

        phoneList.sort(Comparator.comparing(p -> p.fio));
        System.out.println("Список после сортировки по ФИО:");
        System.out.println(phoneList.toString().toString());

        phoneList.sort(Comparator.comparing(p -> p.phonesnum.get(0)));
        System.out.println("Список после сортировки по первому телефону:");
        System.out.println(phoneList.toString().toString());

        phoneList.set(0, phoneList.get(0).setFio("Порки Джон"));
        System.out.println("Список после изменения ФИО первого элемента:");
        System.out.println(phoneList.toString());

        phoneList.remove(1);
        System.out.println("Список после удаления:");
        System.out.println(phoneList.toString());

        System.out.println("Список в json формате:");
        String phBookJson = mapper.writeValueAsString(phoneList);
        System.out.println(phBookJson);

        System.out.println("Создаем файл и загружаем в него данные");
        File file = new File("E:\\PhoneBook.dat");
        Files.deleteIfExists(Paths.get("E:\\PhoneBook.dat"));
        file.createNewFile();
        System.out.println("Файл создан");
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(phoneList);
        objectOutputStream.close();
        System.out.println("Данные загружены в файл");

        System.out.println("Получаем данные из файла");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        List<PhoneBook> phoneList1 = (List<PhoneBook>) objectInputStream.readObject();
        System.out.println("Список из файла в json формате:");
        String phBookJson1 = mapper.writeValueAsString(phoneList1);
        System.out.println(phBookJson1);
    }
}

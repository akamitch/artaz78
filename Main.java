package com.test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// http://blog.harrix.org/article/7348 по этой доке подключал gson

        System.out.println("используя gson");
        User vasiliy = new User("Vasiliy", 30);
        Gson gson = new Gson();
        System.out.println(gson.toJson(vasiliy));

        String s = "{\"name\":\"Petr\",\"age\":35}";
        User petr = gson.fromJson(s, User.class);

        System.out.println("name: " + petr.name + " age :" + petr.age);

        System.out.println("\n---------------------");
        System.out.println("используя jacson");

        ObjectMapper mapper = new ObjectMapper();
        try {
            String sJ = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vasiliy);
            System.out.println(sJ);
            s = sJ;
        }
        catch (IOException e){
            System.out.println("jacson не смог перевести обьект в json");
        }
        try {
            User petrJ = mapper.readValue(s, User.class);
            System.out.println("name: " + petrJ.name + " age :" + petrJ.age);
        }
        catch (IOException e) {
            System.out.println("jacson не смог распарсить строку: ");
            System.out.println(s);
        }



    }
}

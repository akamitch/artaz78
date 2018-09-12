package com.test;


import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
	// http://blog.harrix.org/article/7348 по этой доке подключал gson

        User vasiliy = new User("Vasiliy", 30);
        Gson gson = new Gson();
        System.out.println(gson.toJson(vasiliy));

        String s = "{\"name\":\"Petr\",\"age\":35}";
        User petr = gson.fromJson(s, User.class);

        System.out.println("name: " + petr.name + " age :" + petr.age);
    }
}

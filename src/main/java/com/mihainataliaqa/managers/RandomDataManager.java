package com.mihainataliaqa.managers;

import com.github.javafaker.Faker;

public class RandomDataManager {

    private static Faker fakerObject = new Faker();

        public static String getRandomEmail() {

        String email = fakerObject.internet().emailAddress();
        return email;
    }

    public static String getRandomFirstName() {
        return  fakerObject.name().firstName();
    }

    public static String getRandomLastName() {
        return  fakerObject.name().lastName();
    }

    public static String getRandomPasw() {
        return  fakerObject.internet().password();
    }
}

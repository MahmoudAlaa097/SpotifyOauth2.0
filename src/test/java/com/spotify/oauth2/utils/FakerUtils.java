package com.spotify.oauth2.utils;

import com.github.javafaker.Faker;

public class FakerUtils {
    private static String fakerBuilder(String regex) {
        Faker faker = new Faker();
        return faker.regexify(regex);
    }

    public static String generateName() {
        return fakerBuilder("[A-Za-z0-9 ,_-]{15}");
    }

    public static String generateDescription() {
        return fakerBuilder("[A-Za-z0-9 _@,/#&+-]{50}");
    }

    public static String generateToken() {
        return fakerBuilder("[A-Za-z0-9 -]{10}");
    }

    public static String generateId() {
        return fakerBuilder("[A-Za-z0-9]{10}");
    }
}

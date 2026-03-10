package utils;

import java.util.Random;

public class RandomDataUtil {

    public static String generateRandomEmail() {

        Random rand = new Random();
        int num = rand.nextInt(10000);

        return "user" + num + "@gmail.com";
    }

}
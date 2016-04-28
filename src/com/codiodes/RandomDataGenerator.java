package com.codiodes;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

/**
 * Created by salmankhan on 28/04/16.
 */
public class RandomDataGenerator {

    private SecureRandom random;

    public RandomDataGenerator() {
        random = new SecureRandom();
    }

    public int generateRandomNumber() {
        return random.nextInt();
    }

    public int generateRandomNumberInRange(int min, int max) {
        random.setSeed(new Date().getTime());
        return random.nextInt(max - min + 1) + min;
    }

}

package org.example.tests;

import org.example.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    protected ApplicationManager applicationManager;

    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
    }

    public static String getRandomString(int minLength, int maxLength) {
        String alphabet = "qwertyuiopasdfghjklzxcvbnmйцукенгшщзхъфывапролджэячсмитьбюё1234567890";
        alphabet = alphabet + alphabet.toUpperCase();
        char[] chars = alphabet.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < Math.round(Math.random() * (maxLength - minLength)) + minLength; j++) {
            stringBuilder.append(chars[(int) Math.round(Math.random() * (chars.length - 1))]);
        }
        stringBuilder.append(" ");
        return stringBuilder.toString().trim();
    }

}

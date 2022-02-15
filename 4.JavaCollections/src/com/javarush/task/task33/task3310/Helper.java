package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Helper {
    public static String generateRandomString(){
        StringBuilder password = new StringBuilder();
        password.append(new BigInteger(130, new SecureRandom()).toString(36));
        return password.toString();
    }
    public static void printMessage(String message){
        System.out.println(message);
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println();
    }
}

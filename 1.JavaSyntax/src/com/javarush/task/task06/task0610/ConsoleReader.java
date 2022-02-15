package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public static int readInt() throws Exception {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    public static double readDouble() throws Exception {
        Scanner s = new Scanner(System.in);
        return s.nextDouble();

    }

    public static boolean readBoolean() throws Exception {
        Scanner s = new Scanner(System.in);
        return s.nextBoolean();

    }

    public static void main(String[] args) throws Exception {

    }
}

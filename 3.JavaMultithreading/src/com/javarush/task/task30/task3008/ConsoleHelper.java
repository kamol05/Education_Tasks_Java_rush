package com.javarush.task.task30.task3008;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt(){
        int result = 0;
        while (true){
            try {
                result = Integer.valueOf(readString().trim());
                break;
            } catch (NumberFormatException n) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        } return (int) result;
    }

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String result = "";
        while (true){
            try {
                result = reader.readLine();
                break;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        } return result;
    }



}

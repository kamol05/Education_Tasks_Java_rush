package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
        System.out.println(getPartOfString(null));
        System.out.println(getPartOfString(" asfas asf faf"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        String[] s = string.split(" ");
        if (s.length <= 4) throw new TooShortStringException();
        String ss = "";
        for (int i = 1; i < 5 ; i++) {
            ss += s[i] + " ";
        }
        return ss.substring(0,ss.length() -1);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}

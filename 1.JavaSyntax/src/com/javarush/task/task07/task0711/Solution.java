package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> str = new ArrayList<String>();
        for (int i = 5; i > 0; i--)
        {
            String s = reader.readLine();
            str.add(s);
        }
        for (int i = 13; i > 0; i--)
        {
            int a = 4;
            String s = str.get(a);
            str.remove(a);
            str.add(0,s);
        }
        for (int i = 0; i < str.size(); i++)
        {
            System.out.println(str.get(i));
        }
    }
}

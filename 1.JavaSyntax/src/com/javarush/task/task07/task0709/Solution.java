package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> str = new ArrayList<String>();
        ArrayList<String> str2 = new ArrayList<String>();

        for (int i = 0; i < 5; i++)
        {
            str.add(reader.readLine());
        }


        int min = str.get(0).length();
        for (int i = 0; i < str.size(); i++)
        {
            String s2 = str.get(i);
            if (s2.length() < min)
            {
                min = str.get(i).length();
            }
        }

        for (int i = 0; i < str.size(); i++)
        {
            if (str.get(i).length() == min)
            System.out.println(str.get(i));
        }

    }
}

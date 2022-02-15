package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<String>();
        //напишите тут ваш код
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++)
        {
            String s = reader.readLine();
            strings.add(s);
        }
        for (int i = 0; i < m; i++)
        {
            String s = strings.get(0);
            strings.add(s);
            strings.remove(0);
        }
        for (String s : strings){
            System.out.println(s);
        }
    }
}

package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(reader.readLine());
        }
        ArrayList<String> result = doubleValues(list);
        for (String e : result
             ) {
            System.out.println(e);

        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> ar = new ArrayList<>();
        for (String s : list
             ) { ar.add(s);
             ar.add(s);

        }
        return ar;
    }
}

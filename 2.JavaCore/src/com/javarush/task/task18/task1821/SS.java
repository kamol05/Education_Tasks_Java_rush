package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Встречаемость символов
*/

public class SS {
    public static void main(String[] args) throws FileNotFoundException {
//      String fileName = "d:/1.txt";
        String fileName = args[0];
        TreeMap<Character,Integer> map = new TreeMap<>();
        int counter = 0;
        try (
                Scanner sc =new Scanner(new FileInputStream(fileName));
        )
        {
            while (sc.hasNextLine()){
                String s = sc.nextLine();
                char[] chars = s.toCharArray();
                ArrayList<Character> list = new ArrayList<>();
                for (int i = 0; i < chars.length ; i++) {
                    for (int j = 0; j < chars.length ; j++) {
                        if (chars[i] == chars[j] && !list.contains(chars[i])){
                            counter++;
                            map.put(chars[i],counter );
//                            System.out.println(map.entrySet());
                        }
                    }
                    counter = 0;
                    list.add(chars[i]);
                }
            }
            sc.close();
//            System.out.println(counter);
            for(Map.Entry<Character, Integer> item : map.entrySet()){
                System.out.println(item.getKey() + " " + item.getValue());

            }

        }
    }
}

package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            strings.add(reader.readLine());}
        int max = strings.get(0).length();
        int min = strings.get(0).length();
        for (String s : strings)
            if (s.length() > max){
                max = s.length();
            }
            else if (s.length() < min){
                min = s.length();
            }
        for (String s1 : strings){
            if (s1.length() == max)
            {
                /*for (String s : strings)
                {
                    if (s.length() == max)

                }*/
                System.out.println(s1);
                break;
            }else if (s1.length() == min)
            {
                /*for (String s : strings)
                {
                    if (s.length() == min)

                }*/
                System.out.println(s1);
                break;
            }
            }

    }
}

package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.sql.*;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<String>();
        String s1 = "end";
        while (true){
            String s = reader.readLine();
            if (s.equals(s1))
            {
                break;
            }
            strings.add(s);
        }for (String s2 : strings)
        {
            System.out.println(s2);
        }
    }


}
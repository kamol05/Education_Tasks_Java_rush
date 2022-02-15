package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
Иванов Иван Иванович 31 12 1987   6
Иванов Вася 15 5 2013             5
Вася 15 5 2013                    4


*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String filename;
            filename = args[0];
//            filename = "c:/1.txt";

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String name = null;
        String strindate;
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyy");
        Date date = new Date();
        String line = null;

        while ((line = reader.readLine()) != null){
            String [] s = line.split(" ");
            if (s.length == 6)
            {
                name = s[0] + " " + s[1] + " "+ s[2];
                strindate = s[3] + " " + s[4] + " "+ s[5];
                date = format.parse(strindate);
                PEOPLE.add(new Person(name,date));
            }
            else if (s.length == 5)
            {
                name = s[0] + " " + s[1];
                strindate = s[2] + " " + s[3] + " "+ s[4];
                date = format.parse(strindate);
                PEOPLE.add(new Person(name,date));
            }
            else if (s.length == 4)
            {
                name = s[0];
                strindate = s[1] + " " + s[2] + " "+ s[3];
                date = format.parse(strindate);
                PEOPLE.add(new Person(name,date));
            }
        }
        reader.close();

        /*for (Person p : PEOPLE){
            System.out.println(p.getName() + " " +p.getBirthDate());
        }*/


    }
}

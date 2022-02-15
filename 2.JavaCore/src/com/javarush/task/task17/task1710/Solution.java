package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        String param;
        int id;
        String name;
        Sex sex = null;
        Date date;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);

        switch (args[0]){
            case "-u":
                id = Integer.parseInt(args[1]);
                Person p1 = allPeople.get(id);
                p1.setName(args[2]);
                p1.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
                String s = args[4];
                date = formatter.parse(s);
                p1.setBirthDate(date);
                break;
            case "-c":
                name = args[1];
                sex = args[2].equals("м") ? Sex.MALE : Sex.FEMALE;

                String dateString = args[3];
                date = formatter.parse(dateString);
                Person p = Person.createMale(name,date);
                p.setSex(sex);

                allPeople.add(p);
                System.out.println(allPeople.indexOf(p));
                break;
            case "-d":
                id = Integer.parseInt(args[1]);
                Person p3 = allPeople.get(id);
                p3.setName(null);
                p3.setSex(null);
                p3.setBirthDate(null);
                break;
            case "-i":
                id = Integer.parseInt(args[1]);
                Person p4 = allPeople.get(id);
                String sex1 = p4.getSex().equals(Sex.MALE) ? "м" : "ж";

                Date d = p4.getBirthDate();
                DateFormat df = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
                String datep4 = df.format(d);

                System.out.println(p4.getName()+ " "+ sex1 +" "+ datep4);
                break;
        }


        // -c name sex bd
        // -u id name sex bd
        // -d id
        // -i id

    }
}

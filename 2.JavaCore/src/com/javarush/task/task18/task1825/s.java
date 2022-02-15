package com.javarush.task.task18.task1825;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.IntBuffer;
import java.util.*;

/*
Собираем файл
          Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37

          public class ComparatorDemo {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Joe", 24),
                new Person("Pete", 18),
                new Person("Chris", 21)
        );
        Collections.sort(people, (a, b) -> a.name.compareToIgnoreCase(b.name));
        System.out.println(people);
        Collections.sort(people, (a, b) -> a.age < b.age ? -1 : a.age == b.age ? 0 : 1);
        System.out.println(people);
    }
}
*/

public class s {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            TreeMap<Integer, String> map = new TreeMap<>();
            String fileName = "";
            File file = null;

            while (!(fileName = reader.readLine()).equals("end")) {
                String temp = fileName;
                map.put(Integer.parseInt(s.toe(fileName)), fileName);
                file = new File(s.toe2(temp));
            }


            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (Map.Entry<Integer, String> m : map.entrySet()) {
                FileInputStream f = new FileInputStream(m.getValue());
                while (f.available() > 0)
                {
                    byteArrayOutputStream.write(f.read());
                }
            }

            FileOutputStream fw = new FileOutputStream(file);
            byteArrayOutputStream.writeTo(fw);
            reader.close();
            byteArrayOutputStream.close();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static String toe(String s) {
        String[] temp = s.split(".part");
        return temp[temp.length -1];
    }
    public static String toe2(String s) {
        String[] temp = s.split("\\.");
        return temp[0] + "." + temp[1];
    }
}

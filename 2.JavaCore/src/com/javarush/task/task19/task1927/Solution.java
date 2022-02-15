package com.javarush.task.task19.task1927;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream original = System.out;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bout);
        System.setOut(printStream);
        testString.printSomething();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bout.toByteArray())));
        int counter = 0;
        String lines = "";
        while (reader.ready()){
            if (counter != 2)
            {
                lines += reader.readLine();
                lines += '\n';
                counter++;
            }
            if (counter == 2)
            {
                lines += "JavaRush - курсы Java онлайн";
                lines += '\n';
                counter = 0;
            }
        }
        System.setOut(original);
        System.out.println(lines);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

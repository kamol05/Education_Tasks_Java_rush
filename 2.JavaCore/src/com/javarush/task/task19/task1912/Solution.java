package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream streamOut = new PrintStream(byteArrayOutputStream);
        System.setOut(streamOut);
        testString.printSomething();
        String text = byteArrayOutputStream.toString().replaceAll("te","??");

        System.setOut(originalOut);
        System.out.println(text);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

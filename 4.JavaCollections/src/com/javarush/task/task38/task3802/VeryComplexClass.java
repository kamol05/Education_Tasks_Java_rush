package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileReader;
import java.io.InputStreamReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        InputStreamReader inputStreamReader = new FileReader("d");
    }

    public static void main(String[] args) {

    }
}

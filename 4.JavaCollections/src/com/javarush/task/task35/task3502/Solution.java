package com.javarush.task.task35.task3502;

import java.util.ArrayList;
import java.util.List;

/* 
Знакомство с дженериками
*/

public class Solution <T extends List<Solution.SomeClass>> {

    public static class SomeClass <T extends Number> {
    }

    public static void main(String[] args) {

        SomeClass<Integer> some = new SomeClass<>();

        Solution<ArrayList<SomeClass>> solution = new Solution<>();


    }
}

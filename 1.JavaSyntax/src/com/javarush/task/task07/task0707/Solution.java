package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<String>();
        str.add("absc");
        str.add("adfa");
        str.add("sdfs");
        str.add("adasd");
        str.add("dsfdd");
        int n = str.size();
        System.out.println(n);
        for (int i = 0; i < str.size(); i++)
        {
            String s = str.get(i);
            System.out.println(s);
        }

    }
}

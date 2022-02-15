package com.javarush.task.task37.task3703;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* 
Найти класс по описанию Ӏ Java Collections: 7 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("Gamma",  3);
        map.put("Omega", 24);
        map.put("Alpha",  1);

        for (Map.Entry<String,Integer> m : map.entrySet()){
            System.out.println(m.getKey() +"="+ m.getValue());
        }

    }

    public static Class getExpectedClass() {
        return ConcurrentSkipListMap.class;
    }
}

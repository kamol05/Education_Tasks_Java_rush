package com.javarush.task.task36.task3607;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
//        Queue.class.getDeclaredClasses();
        return new DelayQueue().getClass();
    }
}

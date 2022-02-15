package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread th1 = new SpecialThread();
        SpecialThread th2 = new SpecialThread();
        SpecialThread th3 = new SpecialThread();
        SpecialThread th4 = new SpecialThread();
        SpecialThread th5 = new SpecialThread();

        Thread t1 = new Thread(th1);
        Thread t2 = new Thread(th2);
        Thread t3 = new Thread(th3);
        Thread t4 = new Thread(th4);
        Thread t5 = new Thread(th5);

        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);

        //list.forEach(a -> a.run());
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}

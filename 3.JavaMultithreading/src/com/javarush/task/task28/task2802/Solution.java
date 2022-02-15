package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {
    public static void main(String[] args) {

        class EmulatorThreadFactoryTask implements Runnable {

            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory{
        public static final AtomicInteger A = new AtomicInteger(1);
        private int aa = 0;
        private AtomicInteger B = new AtomicInteger(0);

        public AmigoThreadFactory() {
            aa = A.getAndIncrement();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setPriority(5);
            thread.setDaemon(false);
            thread.setName(Thread.currentThread().getThreadGroup().getName() + "-pool-" + aa + "-thread-" + B.incrementAndGet());
            return thread;
        }
    }
}

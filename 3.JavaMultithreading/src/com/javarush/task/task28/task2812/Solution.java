package com.javarush.task.task28.task2812;

import java.util.List;
import java.util.concurrent.*;

/* 
ShutdownNow!
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }
//        executor.shutdownNow();
//        executor.awaitTermination(5, TimeUnit.SECONDS);
        for (Runnable r : executor.shutdownNow()){
            System.out.println(r);
        }
    }
    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}

package com.javarush.task.tests;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class test {
    static final long numbOfOperations = 1_000_000_000_000L;

    static final int numbOfCores = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        System.out.println();
        System.out.println(new Date());

        ForkJoinPool pool = new ForkJoinPool(numbOfCores);
        System.out.println(pool.invoke(new MyFork(0, numbOfOperations)));

        System.out.println(new Date());
    }
    private static class MyFork extends RecursiveTask<Long> {
        private long from;
        private long to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ( (to - from) <= numbOfOperations/numbOfCores ){
                long l = 0;
                for (long i = from; i < to; i++) {
                    l += i;
                } return l;
            }
            else {
                long middle = (to + from) / 2;
                MyFork firstHalf = new MyFork(from,middle);
                firstHalf.fork();

                MyFork secondHalf = new MyFork(middle + 1,to);
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}

package com.javarush.task.task20.task2025;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/* 
Алгоритмы-числа
*/

public class Solution {
    public static SortedSet<Long> set = Collections.synchronizedSortedSet(new TreeSet<Long>());

    public static void myLogic(long from, long to) {
        while (to > from - 1)
        {
            long temp = 0L;
            long k;
            char[] sum = Long.toString(to).toCharArray();
            for (int i = 0; i <sum.length; i++) {
                long sumi = Long.parseLong(String.valueOf(sum[i]));
                k = sumi;
                for (int sumLenght = sum.length -1; sumLenght > 0; sumLenght--) {
                    k *= sumi;
                }
                temp += k;
            }
            if (to == temp)
            {
                set.add(temp);
            }
            to--;
        }
    }

    public static long[] getNumbersMyLogic(long N) {
        //        222
        long[] result = new long[0];
        while (N > 0)
        {
            int temp = 0;
            int k;
            char[] sum = Long.toString(N).toCharArray();
            for (int i = 0; i <sum.length; i++) {

                int sumi = Integer.parseInt(String.valueOf(sum[i]));
                k = sumi;
                for (int sumLenght = sum.length -1; sumLenght > 0; sumLenght--) {
                    k *= sumi;
                }
                temp += k;
            }
            if (N == temp)
            {
                long[] tempL = Arrays.copyOf(result,result.length + 1);
                result = Arrays.copyOf(tempL,tempL.length);
                result[tempL.length -1] = temp;
            }
//            System.out.println(N);
            N--;
        }
        return result;
    }
    public static long[] getNumbers(long N) {
        MyFork myfork = new MyFork(0,N);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(myfork);

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long[] l = set.stream().mapToLong(Number::intValue).toArray();
        return l;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }

    public static class MyFork extends RecursiveAction{
        private long from;
        private long to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected void compute() {
            if ( (to - from) > 100000 ){
                /* from  0         */
                /*  to   10 000    */
                /* from  5001         */
                /*  to   10 000    */
                long middle = ( to - from ) / 2; /* 10 000 */
//               long ffrom = 0; /* 0   */
//                long fto   = 0; /* 5 000 */
//                long sfrom = 0; /* 5001   */
//                long sto   = 0; /* 10 000 */
                MyFork firstHalf = new MyFork(from,from + middle);
                MyFork secondHalf = new MyFork(from + middle,to);
                invokeAll(firstHalf,secondHalf);
            }else {
                myLogic(from,to);
            }
        }
    }
}

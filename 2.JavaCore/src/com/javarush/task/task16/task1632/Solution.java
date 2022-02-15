package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new S1()));
        threads.add(new Thread(new S2()));
        threads.add(new Thread(new S3()));
        threads.add(new S4());
        threads.add(new Thread(new S5()));
    }

    public static void main(String[] args) {

    }

    public static class S1 implements Runnable{
        @Override
        public void run() {
            while (true){ }
        }
    }
    public static class S2 implements Runnable{

        @Override
        public void run(){
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }
    public static class S3 implements Runnable{
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class S4 extends Thread implements Message {
        public void run() {
            while (!isInterrupted()) {
            }
        }

        public void showWarning() {
            this.interrupt();
        }
    }
    public static class S5 implements Runnable{
        @Override
        public void run() {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            int i = 0;
            while (!s.equals("N"))
            {
                i = i + Integer.parseInt(s);
                s = sc.nextLine();

            }System.out.println(i);

        }
    }
}
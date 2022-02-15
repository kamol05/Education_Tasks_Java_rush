package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader1.readLine();
        } catch (IOException e) {
            System.out.println("filerider");
        }

    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        static String fileNNN;
        static String stroki = "";
        public void setFileName(String fullFileName) {
            fileNNN = fullFileName;
        }


        public void run() {
            try {
                stroki = "";
                Scanner sc =  new Scanner(new FileReader(fileNNN));
                while (sc.hasNextLine()) {
                    stroki += sc.nextLine() + " ";
                }
                sc.close();
            }catch (Exception e){
                System.out.println("runga");
                e.printStackTrace();
            }
        }


        public String getFileContent() {
            return stroki;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        try {
            f.setFileName(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("syout");
        }
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName) throws FileNotFoundException;

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

}

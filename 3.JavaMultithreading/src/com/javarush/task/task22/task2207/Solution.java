package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {


    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        String filename = "1.txt";
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        filename = reader.readLine();
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(new FileReader(filename));
        while (scanner.hasNextLine()){
            sb.append(scanner.nextLine());
        }

        String[] rss = sb.toString().split(" ");

        sb.toString().contains(rss[0]);


//        рот тор торт о о тот тот тот
        for (int i = 0; i <rss.length ; i++) {

            if (sb.toString().contains(rss[i])) {
                int index1 = sb.toString().indexOf(rss[i]);
                int lenght1 = rss[i].length();
                sb.replace(index1, index1 + lenght1 , "");

                if (sb.toString().contains(rss[i]))
                {
                    int index = sb.toString().indexOf(rss[i]);
                    int lenght = rss[i].length();sb.replace(index, index + lenght , "");
                    Pair p = new Pair();
                    p.second = rss[i];
                    result.add(p);
                }
            }
        }



        for (Pair p : result){
            System.out.println(p.first +" "+ p.second);
        }

    }


    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }



}

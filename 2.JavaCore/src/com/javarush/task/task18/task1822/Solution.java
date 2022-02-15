package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Поиск данных внутри файла
В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

id productName price quantity
int String double int
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String lineOnFile = "";

        String fileName = reader.readLine();
        int id = Integer.parseInt(args[0]);

//        String fileName = "d:/1.txt";
//        int id = 568474;

        FileInputStream fs = new FileInputStream(fileName);
        Scanner sc = new Scanner(fs);
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNextLine()){
            lineOnFile = sc.nextLine();
            int idfor = Integer.parseInt(separator(lineOnFile)[0]);
            if (id == idfor) break;
        }
        reader.close();
        fs.close();
        sc.close();
        System.out.println(lineOnFile);
    }

    public static String[] separator(String lines){
        String [] line = lines.split(" ");
        return line;
    }
}

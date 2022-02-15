package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.*;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String firstFileName = scanner.nextLine();
        String secondfileName = scanner.nextLine();
//        Scanner fileScan1 = new Scanner(new FileInputStream(firstFileName));
//        Scanner fileScan2 = new Scanner(new FileInputStream(secondfileName));
        FileReader fr1 = new FileReader(firstFileName);
        FileReader fr2 = new FileReader(secondfileName);
        Scanner fileScan1 = new Scanner(fr1);
        Scanner fileScan2 = new Scanner(fr2);

        while (fileScan1.hasNextLine()){
            allLines.add(fileScan1.nextLine());
        }
        while (fileScan2.hasNextLine()){
            forRemoveLines.add(fileScan2.nextLine());
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            System.out.println(e);
        }


    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);

        }
        else if (!allLines.equals(forRemoveLines)){
            allLines.clear(); throw new CorruptedDataException();
        }

    }
}

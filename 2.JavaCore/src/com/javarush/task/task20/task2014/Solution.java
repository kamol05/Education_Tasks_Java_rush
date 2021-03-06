package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        System.out.println(new Solution(4));
        Solution savedObject = new Solution(5);

        FileOutputStream fos = new FileOutputStream("1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(savedObject);

        fos.close();
        oos.close();

        System.out.println(new Solution(8));

        ObjectInputStream ios = new ObjectInputStream(new FileInputStream("1.txt"));
        Solution loadedObject = (Solution) ios.readObject();
        ios.close();

        System.out.println(savedObject.string.endsWith(loadedObject.string));

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}

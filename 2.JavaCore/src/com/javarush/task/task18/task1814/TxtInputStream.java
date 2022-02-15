package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String file) throws IOException, UnsupportedFileNameException {
        super(file);

        if (!file.endsWith(".txt")){
            super.close();
            throw new UnsupportedFileNameException();
        }


    }

    public static void main(String[] args) throws UnsupportedFileNameException, IOException {
        TxtInputStream t = new TxtInputStream("C:/tmp/result.exe");
    }
}


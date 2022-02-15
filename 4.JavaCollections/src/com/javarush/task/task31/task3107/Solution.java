package com.javarush.task.task31.task3107;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Null Object Pattern
*/

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        Path file = Paths.get(pathToFile);
        try {
            fileData = new ConcreteFileData(Files.isHidden(file), Files.isExecutable(file), Files.isDirectory(file), Files.isWritable(file));
        } catch (IOException e) {
            fileData = new NullFileData(e);
            e.printStackTrace();
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}

package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

//    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
//        // implement this method
//        URL url = new URL(urlString);
//        InputStream inputStream = url.openStream();
//        Path tempfile = Files.createTempFile("tmp-",".txt");
//        Files.copy(inputStream,tempfile);
//        Files.move(tempfile,downloadDirectory);
//        return downloadDirectory;
//    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        String fileName = urlString.split("/")[urlString.split("/").length - 1];
//        String filee = urlString.split("/")[]
        Path downloadPath = downloadDirectory.resolve(fileName);

        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile(null,null);
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

        Files.move(tempFile, downloadPath);
        return downloadPath;
    }
}

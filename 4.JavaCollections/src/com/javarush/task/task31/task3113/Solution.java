package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution extends SimpleFileVisitor<Path> {
    private final static AtomicInteger folderCounts = new AtomicInteger(-1);
    private final static AtomicInteger fileCounts = new AtomicInteger(0);
    private final static AtomicLong allSize = new AtomicLong(0);


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String directoryName = reader.readLine();
        Path path = Paths.get(directoryName);
        if (!Files.isDirectory(path)){
            System.out.println(path + " - не папка");
            return;
        }
        Solution solution = new Solution();
        System.out.println("Всего папок - " + folderCounts);
        System.out.println("Всего файлов - "+ fileCounts);
        System.out.println("Общий размер - " + allSize);

    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        folderCounts.getAndIncrement();
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if ( !Files.isDirectory(file) ){
            fileCounts.getAndIncrement();
        }
        allSize.addAndGet(Files.size(file));
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return super.postVisitDirectory(dir, exc);
    }

}

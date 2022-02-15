package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    FileOutputStream fileOutputStream;

    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream (FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        this.fileOutputStream.write(b);
    }
    @Override
    public void write(byte[] b) throws IOException {
        this.fileOutputStream.write(b);
    }
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.fileOutputStream.write(b, off, len);
    }
    @Override
    public FileChannel getChannel() {
        return fileOutputStream.getChannel();
    }

    @Override
    public void close() throws IOException {
        flush();
        write("JavaRush © All rights reserved.".getBytes());
        fileOutputStream.close();
    }
}

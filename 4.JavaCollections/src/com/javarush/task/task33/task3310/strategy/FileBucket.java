package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;
    public FileBucket() {
        try {
            path = Files.createTempFile(Integer.toHexString(hashCode()), ".tmp");
            path.toFile().deleteOnExit();

            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {

        }
    }
    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        } return 0L;
    }
    public void putEntry(Entry entry){
        do {
            try(
                    ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
            ){
                oos.writeObject(entry);
            }catch (Exception e){

            }
            entry = entry.next;
        } while (entry != null);
    }
    public Entry getEntry(){
        if (getFileSize() > 0) {
            Entry entry = null;
            try (
                    ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));
            ) {
                entry = (Entry) ois.readObject();
                return entry;
            } catch (Exception e) {
            }
        }
        return null;
    }
    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

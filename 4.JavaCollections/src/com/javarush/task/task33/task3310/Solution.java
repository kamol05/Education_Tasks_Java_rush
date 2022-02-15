package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        HashMapStorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy,10000);
        OurHashMapStorageStrategy strateg2 = new OurHashMapStorageStrategy();
        testStrategy(strateg2,10000);
        FileStorageStrategy strategy3 = new FileStorageStrategy();
        testStrategy(strategy3,25);
        OurHashBiMapStorageStrategy strategy4 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy4,10000);
        HashBiMapStorageStrategy strategy5 = new HashBiMapStorageStrategy();
        testStrategy(strategy5,10000);
        DualHashBidiMapStorageStrategy strategy6 = new DualHashBidiMapStorageStrategy();
        testStrategy(strategy6,10000);


    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> set = new HashSet<>();
        Set<Long> longSet = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (int i = 0; i <elementsNumber ; i++) {
            set.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        long timeNow = new Date().getTime();
        for (String s : set){
            longSet.add(shortener.getId(s));
        }

        long timeNew = new Date().getTime();
        Helper.printMessage(String.valueOf(timeNew - timeNow) );

        long time3 = new Date().getTime();
        for (Long l : longSet){
            set2.add(shortener.getString(l));
        }

        long time4 = new Date().getTime();
        Helper.printMessage(String.valueOf(time4 - time3) );

        Integer i = null;
        Integer i2 = null;
        set.removeAll(set2);
        set2.removeAll(set);
        i = set.size();
        i2 = set.size();
        if (i == 0 && i2 == 0){
            Helper.printMessage("Тест пройден.");
        } else
            Helper.printMessage("Тест не пройден.");


    }

    public static Set<Long> getIds(Shortener shortener,Set<String> strings){
        Set<Long> set = new HashSet<>();
        for(String s : strings){
            set.add(shortener.getId(s));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener,Set<Long> keys){
        Set<String> set = new HashSet<>();
        for(Long l : keys){
            set.add(shortener.getString(l));
        }
        return set;
    }
}

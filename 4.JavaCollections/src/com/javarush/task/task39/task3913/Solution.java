package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
////        System.out.println(logParser.getNumberOfUniqueIPs(new Date(), new Date()));
//
//        System.out.println(logParser.getIPsForUser("Eduard Petrovich Morozko",null, null));
//
////        System.out.println(logParser.getIPsForEvent(Event.WRITE_MESSAGE,new Date(), new Date()));
////
////        System.out.println(logParser.getIPsForStatus(Status.FAILED,new Date(), new Date()));
//
//        System.out.println(logParser.getNumberOfUsers(null,null));
//        System.out.println(logParser.getNumberOfUserEvents("Amigo",null,new Date()));
//        System.out.println(logParser.getUsersForIP("127.0.0.1",null,null));
//        System.out.println(logParser.getLoggedUsers(null,null));
//        System.out.println(logParser.getSolvedTaskUsers(null,null,18));
//        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Vasya Pupkin",new Date(),new Date()));
//        System.out.println(logParser.execute("get user"));
        System.out.println(logParser.execute("get field1 for field2 = \"value1\"\n"));
    }
}
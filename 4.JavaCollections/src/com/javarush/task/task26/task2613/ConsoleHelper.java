package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String text = bis.readLine();
            if ("exit".equals(text.toLowerCase())) {
                throw new InterruptOperationException();
            }

            return text;
        } catch (IOException ignored) { //suppose it will never occur
        }
        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            com.javarush.task.task26.task2613.ConsoleHelper.writeMessage("Please choose a currency code, for example USD");
            String currencyCode = com.javarush.task.task26.task2613.ConsoleHelper.readString();
            if (currencyCode == null || currencyCode.trim().length() != 3) {
                com.javarush.task.task26.task2613.ConsoleHelper.writeMessage("Please specify valid data.");
                continue;
            }
            return currencyCode.trim().toUpperCase();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            com.javarush.task.task26.task2613.ConsoleHelper.writeMessage(String.format("Please specify integer denomination and integer count. For example '10 3' means 30 %s", currencyCode));
            String s = com.javarush.task.task26.task2613.ConsoleHelper.readString();
            String[] split = null;
            if (s == null || (split = s.split(" ")).length != 2) {
                com.javarush.task.task26.task2613.ConsoleHelper.writeMessage("Please specify valid data.");
            } else {
                try {
                    if (Integer.parseInt(split[0]) <= 0 || Integer.parseInt(split[1]) <= 0)
                        com.javarush.task.task26.task2613.ConsoleHelper.writeMessage("Please specify valid data.");
                } catch (NumberFormatException e) {
                    com.javarush.task.task26.task2613.ConsoleHelper.writeMessage("Please specify valid data.");
                    continue;
                }
                return split;
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            com.javarush.task.task26.task2613.ConsoleHelper.writeMessage("Please choose an operation desired or type 'EXIT' for exiting");
            com.javarush.task.task26.task2613.ConsoleHelper.writeMessage("\t 1 - operation.INFO");
            com.javarush.task.task26.task2613.ConsoleHelper.writeMessage("\t 2 - operation.DEPOSIT");
            com.javarush.task.task26.task2613.ConsoleHelper.writeMessage("\t 3 - operation.WITHDRAW");
            com.javarush.task.task26.task2613.ConsoleHelper.writeMessage("\t 4 - operation.EXIT");
            Integer i = Integer.parseInt(com.javarush.task.task26.task2613.ConsoleHelper.readString().trim());
            try {
                return Operation.getAllowableOperationByOrdinal(i);
            } catch (IllegalArgumentException e) {
                com.javarush.task.task26.task2613.ConsoleHelper.writeMessage("Please specify valid data.");
            }
        }
    }

}

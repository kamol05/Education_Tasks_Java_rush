package com.javarush.task.task24.task2412;

import java.text.*;
import java.util.*;

/* 
Знания - сила!
*/

public class Solution {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"change {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {

        list.sort(new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {
                String name1 = (String) stock1.get("name");
                String name2 = (String) stock2.get("name");
                Date d1 = (Date) stock1.get("date");
                Date d2 = (Date) stock2.get("date");

                Double m1 = 0.0;
                Double m2 = 0.0;
                Double m3 = 0.0;
                Double m4 = 0.0;

                int pay1 = 0;
                int pay2 = 0;

                if ( (m1 = (Double) stock1.get("open")) != null && (m2 = (Double) stock1.get("last")) != null) {
                        pay1 = (int) (m1 - m2);
                }if( (m3 = (Double) stock2.get("open")) != null && (m4 = (Double) stock2.get("last")) != null) {
                        pay2 = (int) (m3 - m4);
                }

                if (name1.compareTo(name2) != 0)
                    return name1.compareTo(name2);
                if (compareD(d2,d1) != 0 )
                    return compareD(d2,d1);
                return  pay2 - pay1;
            }
        });
    }

    public static int compareD(Date d1, Date d2) {
        if (d1.getYear() != d2.getYear())
            return d1.getYear() - d2.getYear();
        if (d1.getMonth() != d2.getMonth())
            return d1.getMonth() - d2.getMonth();
        return d1.getDate() - d2.getDate();
    }

    public static class Stock extends HashMap<String, Object> {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
//            Date d = new Date(); d.setDate(1);
//            put("date",new Date());
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));


        stocks.add(new Stock("JAVARUSH", "TEST", 666.66, 777.79));
        stocks.add(new Stock("JAVARUSH", "TEST", 666.66, 111.78));
        stocks.add(new Stock("JAVARUSH", "TEST", 666.66, -0.01));
        Date d = new Date(); d.setDate(6); Date d1 = new Date(); d1.setDate(7);
        stocks.add(new Stock("JAVARUSH", "TEST", .7, d));
        stocks.add(new Stock("JAVARUSH", "TEST", .7, d1));

        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}


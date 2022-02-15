package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
//        map.put("name","Ivanov");
//        map.put("countryq","ukrnie");
//        map.put("nameq","Ivanov");
//        map.put("countryqq","ukrnie");

        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder queryBuilder = new StringBuilder();
        for (String s : params.keySet()) {
            String value = params.get(s);
            if (value == null) {
                continue;
            }
            if (queryBuilder.toString().length() != 0) {
                queryBuilder.append(" and ");
            }
            queryBuilder.append(s + " = '" + value + "'");
        }
        return queryBuilder.toString();
    }
}

// {name=Ivanov, country=Ukraine, city=Kiev, age=null}
// name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
//

package com.javarush.task.task40.task4006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            Socket socket = new Socket(url.getHost(),80);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("GET " + url.getPath());
            ps.println("");
            ps.flush();

            BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(buf.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
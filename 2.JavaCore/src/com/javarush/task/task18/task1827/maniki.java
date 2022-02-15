package com.javarush.task.task18.task1827;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.*;

/*
Прайсы

-c productName price quantity
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.
*/

public class maniki {

    public static void main(String[] args) throws Exception {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();

        FileInputStream stream = new FileInputStream(fileName);
        Scanner scanner = new Scanner(stream);
        try {

            if (args[0].equals("-c")) {

                char[] ch = new char[50];
                Arrays.fill(ch, ' ');
                String line = "";
                int idTonum = 0;
                String lin2 = "";
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                }

                for (int i = 0; i < 8 && i < line.length(); i++) {
                    if (line.charAt(i) != ' ') {
                        lin2 += line.charAt(i);
                    }
                }
//          System.out.println(lin2);
                idTonum = Integer.parseInt(lin2);
                idTonum++;
                String id = String.valueOf(idTonum);
                for (int i = 0; i < ch.length; i++) {
                    if (i < id.length()) {
                        ch[i] = id.charAt(i);
                    }
                    if (i > 7 && i < 37) {
                        if (args[1].length() > i - 8) {
                            ch[i] = args[1].charAt(i - 8);
                        }
                    }
                    if (i > 37 && i < 45) {
                        if (args[2].length() > i - 38) {
                            ch[i] = args[2].charAt(i - 38);
                        }
                    }
                    if (i > 45 && i < 50) {
                        if (args[3].length() > i - 46) {
                            ch[i] = args[2].charAt(i - 46);
                        }
                    }
                }

//            System.out.println(ch);
                stream.close();
                FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
                fileOutputStream.write(10);
                fileOutputStream.write(String.valueOf(ch).getBytes());
                fileOutputStream.close();

            }
        }catch (Exception e){

        }
        stream.close();
        scanner.close();

    }
}



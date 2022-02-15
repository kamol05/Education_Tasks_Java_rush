package com.javarush.task.task35.task3507;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().
                getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }
    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<? super Animal> set = new HashSet<>();
        ClassLoader loader = new ClassLoader(){
            @Override
            public Class<?> findClass(String name) throws ClassNotFoundException {
                //Проверяем, существует ли такой файл
                File f = new File(name);
                if(!f.isFile()) {
                    throw new ClassNotFoundException("Нет такого класса " + name);
                }
                InputStream ins = null;
                try{
                    //С помощью потока считываем файл в массив байт
                    ins = new BufferedInputStream(new FileInputStream(f));
                    byte[]b = new byte[(int)f.length()];
                    ins.read(b);
                    //С помощью функции defineClass загружаем класс
                    Class clazz = defineClass(null, b, 0, b.length);
                    return clazz;
                }catch (Exception e){
                    e.printStackTrace();
                    throw new ClassNotFoundException("Проблемы с байт кодом");
                }
                finally {
                    try {
                        ins.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Animal animal = null;
        for (File f : new File(pathToAnimals).listFiles())
        {
            if (f.toString().endsWith(".class")){
                try{
                    Class clazz = loader.loadClass(f.getAbsolutePath());
                    animal = (Animal) clazz.newInstance();
                    set.add(animal);
                } catch (IllegalAccessException e) {
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return (Set<? extends Animal>) set;
    }
}

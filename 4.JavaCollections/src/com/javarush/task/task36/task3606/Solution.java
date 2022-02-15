package com.javarush.task.task36.task3606;

import com.javarush.task.task36.task3606.data.second.FirstHiddenClassImpl;
import com.javarush.task.task36.task3606.data.second.SecondHiddenClassImpl;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File d = new File(packageName);
        for(File f : d.listFiles())
        {
            if (f.toString().endsWith(".class")){
                Class clazz = null;
                try {
                    MyClassLoader loader = new MyClassLoader();
                    clazz = loader.findClass(f.getAbsolutePath());
                    hiddenClasses.add(clazz);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        HiddenClass hiddenClass = null;
        try {
            for (Class clazz : hiddenClasses){
                String name = clazz.getSimpleName();
                if (name.equalsIgnoreCase(key)){
                    hiddenClass = (HiddenClass) clazz.newInstance();
                }else if (name.toLowerCase().contains(key.toLowerCase())){
                    Constructor<HiddenClass> constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    hiddenClass = constructor.newInstance();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return hiddenClass;
    }

    public class MyClassLoader extends ClassLoader {
        //Переопределяем метод findClass, которому надо передать путь к файлу с расширением .class
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
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
                Class c = defineClass(null, b, 0, b.length);
                return c;
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
    }



}


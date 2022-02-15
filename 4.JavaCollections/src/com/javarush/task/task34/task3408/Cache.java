package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        Object o = cache.get(key);
        if (o == null){
//            Class[] classParams = {key.getClass()};  qaysi classni qabul qiladigan constructor kerak
//            Object obj = clazz.getConstructor(classParams).newInstance(key);
//            Solution.SomeValue s  = (Solution.SomeValue) obj;
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));
            o = cache.get(key);
        }
        return (V) o;
    }

    public boolean put(V obj) {
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            Object o1 = (method.invoke(obj));
            cache.put((K) o1,obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}


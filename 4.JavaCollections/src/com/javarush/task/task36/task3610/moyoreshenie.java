package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class moyoreshenie<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public  moyoreshenie(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int count = 0;
        for (Collection<V> c : map.values()){
            for (V v : c){
                count++;
            }
        }
        return count;
    }

    @Override
    public V put(K key, V value) {
        V result = null;
        if (map.containsKey(key))
        {
            List<V> list = map.get(key);
            result = list.get(list.size() -1);
            if (list.size() < repeatCount)
            {
                list.add(value);
                map.put(key,list);
            } else if (list.size() == repeatCount)
            {
                list.remove(0);
                list.add(value);
                map.put(key,list);
            }
        } else  {
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key,list);
        }
        return result;
    }

    @Override
    public V remove(Object key) {
        V v = null;
        if (map.containsKey(key))
        {
            List<V> list = map.get(key);
            if (list.size() > 0){
                v = list.get(0); // will get element with index 0
                list.remove(0);
                map.put((K) key,list);
            } else if (list.isEmpty()){
                map.remove(key);
            }
        } return v;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        List<V> list = new ArrayList<>();
        for (Collection<V> c : map.values()){
            for (V v : c){
                list.add(v);
            }
        } return list;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        boolean result = false;
        for (Collection<V> list : map.values()){
            for (V v : list){
                if (v == value){
                    result = true;
                }
            }
        } return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}
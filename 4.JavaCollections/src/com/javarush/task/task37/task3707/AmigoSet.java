package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
        addAll(collection);
    }

    public Iterator<E> iterator(){
        return map.keySet().iterator();
    }

    @Override
    public boolean add(E e) {
        Object o = map.put(e,PRESENT);
        return o == null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty(){
        return map.isEmpty();
    }

    public boolean contains(Object o){
        boolean b = false;
        if (map.containsKey(o) | map.containsValue(o) ){ b = true; }
        return b;
    }

    public void clear(){
        map.clear();
    }

    public boolean remove(Object o){
        Object obj = map.remove(o);
        return obj != null;
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> newSet = (AmigoSet<E>) super.clone();
            newSet.map = (HashMap<E, Object>) map.clone();
            return newSet;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream oos){
        try {
            oos.defaultWriteObject();
            oos.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
            oos.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));

            for (E e : map.keySet()){
                oos.writeObject(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois){
        try {
             ois.defaultReadObject();
             int capacity = ois.readInt();
             float loadFActor = ois.readFloat();
             this.map = new HashMap<>(capacity,loadFActor);

            for (int i = 0; i < capacity ; i++) {
                map.put((E) ois.readObject(),PRESENT);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}


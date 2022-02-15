package com.javarush.task.task20;

import java.io.Serializable;
import java.util.*;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private int sizeCount;
    private List<Entry<String>> list = new ArrayList<>();
    private List<Entry<String>> copyList = new ArrayList<>();

    public CustomTree() {
        root = new Entry<>("0");
        list.add(root);
    }

    @Override
    public boolean add(String s) {
        Entry<String> temp;
        for (int i = 0; i < list.size() ; i++) {
            temp = list.get(i);

            if (temp.leftChild == null && temp.rightChild == null){
                temp.availableToAddLeftChildren = true;
                temp.availableToAddRightChildren = true;
            }
            if (temp.availableToAddLeftChildren ){
                list.add(temp.leftChild = new Entry<>(s));
                temp.leftChild.parent = temp;
                temp.availableToAddLeftChildren = false;
                sizeCount++;
                break;
            }
            if (temp.availableToAddRightChildren){
                list.add(temp.rightChild =  new Entry<>(s));
                temp.rightChild.parent = temp;
                temp.availableToAddRightChildren = false;
                sizeCount++;
                break;
            }

        } return true;
    }

    @Override
    public boolean remove(Object o) {
        if (copyList.size() == 0){
            copyList = list;
        }
        String removeName;
        try {
            removeName = (String) o;
        }catch (Exception e){ throw new UnsupportedOperationException(); }

        for (Entry<String> entry : copyList){
            if (entry.elementName.equals(removeName)){
                if (entry.leftChild != null){
                    remove(entry.leftChild.elementName);
                }
                if (entry.rightChild != null){
                    remove(entry.rightChild.elementName);
                }
                try {
                    if (entry.parent.leftChild.elementName.equals(removeName)){
                        entry.parent.leftChild = null;
                    } }catch (Exception e){}
                try {
                    if (entry.parent.rightChild.elementName.equals(removeName)){
                        entry.parent.rightChild = null;
                    } }catch (Exception e){}
                list.remove(entry);
                sizeCount--;
                break;
            }
        }
        return true;
    }

    public void removeD(Object o, String s) {
        if (copyList.size() == 0){
            copyList = list;
        }
        String removeName;
        try {
            removeName = (String) o;
        }catch (Exception e){ throw new UnsupportedOperationException(); }
        for (Entry<String> entry : copyList){
            if (entry.elementName.equals(removeName)){

                if (entry.leftChild != null){
                    removeD(entry.leftChild.elementName,"left");
                }
                if (entry.rightChild != null){
                    removeD(entry.rightChild.elementName,"right");
                }

                if (s.equals("left")) {
                    entry.parent.leftChild = null;
                    entry.parent.availableToAddLeftChildren = true;
                }
                else {
                    entry.parent.rightChild = null;
                    entry.parent.availableToAddRightChildren = true;
                }
                list.remove(entry);
                break;
            }
        }
    }


    @Override
    public int size() {
        return sizeCount;
    }

    public String getParent(String s) {
        String parentName = "null";
        for (Entry<String> entry : list){
            if (entry.elementName.equals(s)){
                parentName = entry.parent.elementName;
            }
        }
        return parentName;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }



    static class Entry<T> implements Serializable {

        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        boolean newLineRootElement;
        Entry<T> parent, leftChild, rightChild;

        Entry(String name) {
            elementName = name;
            newLineRootElement = false;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return this.availableToAddRightChildren || this.availableToAddLeftChildren;
        }
    }
}

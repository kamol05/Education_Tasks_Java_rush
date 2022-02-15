package com.javarush.task.task37.task3701;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* 
Круговой итератор
*/

public class Solution<T> extends ArrayList<T> {

    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }


    public class RoundIterator implements Iterator<T>{
        Iterator<T> iter = Solution.super.iterator();

        @Override
        public boolean hasNext() { return (Solution.this.size() > 0);}

        @Override
        public T next() {
            T result;
            try {
                result = iter.next();
            }catch (NoSuchElementException nse){
                iter = Solution.super.iterator();
                result = iter.next();
            }
            return result;
        }

        @Override
        public void remove() {
            iter.remove();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

}


package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            C c = new C(this.getI(),this.getJ(),this.getName());
            return c;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(1,2);
        A a1 = (A) a.clone();
        System.out.println(a1);

        B b = new B(1,2,"b");
        A b1 = (B) b.clone();

        C c = new C(1,2,"c");
        C c1 = (C) c.clone();





    }
}

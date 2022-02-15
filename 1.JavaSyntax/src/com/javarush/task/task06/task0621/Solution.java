package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String gfName = reader.readLine();
        Cat gf = new Cat(gfName);
        String gmName = reader.readLine();
        Cat gm = new Cat(gmName);
        String fatherName = reader.readLine();
        Cat father = new Cat(fatherName,gf);
        String motherName = reader.readLine();
        Cat catMother = new Cat(gm,motherName);
        String sonName = reader.readLine();
        Cat son = new Cat(sonName,father,catMother);
        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, father,catMother);

        System.out.println(gf);
        System.out.println(gm);
        System.out.println(father);
        System.out.println(catMother);
        System.out.println(son);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mother;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat father) {
            this.name = name;
            this.father = father;
        }
        Cat(Cat mother,String name) {
            this.name = name;
            this.mother = mother;
        }
        Cat(String name, Cat father, Cat mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            if (mother == null && father == null )
                 return "The cat's name is " + name + " , no mother, no father";
            else if(mother == null)
                 return "The cat's name is " + name + " , no mother, father is " + father.name;
            else if (father == null)
                 return "The cat's name is " + name + " , mother is " + mother.name + " , no father";
            else
                 return "The cat's name is " + name + " , mother is " + mother.name + " , father is " + father.name;


        }
    }

}

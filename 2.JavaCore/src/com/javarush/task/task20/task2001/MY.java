package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Читаем и пишем в файл: Human
*/

public class MY {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File your_file_name = File.createTempFile("c:/1.txt", null);
            File your_file_name = new File("c:/1.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            ivanov.equals(somePerson);

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

       /*     System.out.println(ivanov.equals(somePerson));
            Human test = new Human("test");
            test.save(outputStream);
            test.load(inputStream);

            Human test1 = new Human();
            test1.save(outputStream);
            test1.load(inputStream);

            System.out.println(test.equals(test1));*/



        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try(
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            ) {
                if (assets.size() > 0)
                {
                    for (Asset a : assets) {
                        writer.write(name + " " + a.getName() + " " + a.getPrice());
                        writer.newLine();
                    }

                }else writer.write(this.name);
                outputStream.flush();
            }catch (Exception ignored){}

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try(
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            ) {
               /* if (assets.size() == 0)
                { this.name = reader.readLine(); }*/

                String line = null;
                List<Asset> copyassets = new ArrayList<>();
                String tempname = null;

                while ((line = reader.readLine()) != null) {
                    String[] s = line.split(" ");
                    tempname = s[0];
                    copyassets.add(new Asset(s[1], Double.parseDouble(s[2])));
                }
                this.name = tempname;
                this.assets.addAll(copyassets);
            }catch (Exception ignored){}
        }
    }
}

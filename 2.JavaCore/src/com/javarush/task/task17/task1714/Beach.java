package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized  String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

        Beach b1 = new Beach("b1",5,10);
        Beach b2 = new Beach("b2",15,20);

        int result = b1.compareTo(b2);
        System.out.println(result);

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int result,a = 0,b =0,n=0;

        if (this.getQuality() == o.getQuality()){
            n++;
        }else if (this.getQuality() > o.getQuality()){
            a++;
        }else b++;

        if (this.getDistance() == o.getDistance()){
            n++;
        }else if (this.getDistance() < o.getDistance()){
            a++;
        }else b++;

        if (a > b){
            result = 1;
        }else if (b > a){
            result = -1;
        }else result = 0;

        return result;
    }
}

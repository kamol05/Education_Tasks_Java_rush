package com.javarush.task.task21.task2113;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hippodrome {

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("horse1",3,0));
        horses.add(new Horse("horse2",3,0));
        horses.add(new Horse("horse3",3,0));
        Hippodrome.game = new Hippodrome(horses);

        game.run();
        game.printWinner();



    }
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    static Hippodrome game;

    void run(){
        for (int i = 1; i < 101; i++) { //101
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move(){
        for (Horse h : getHorses()) {
            h.move();
            System.out.println(h.getName());
        }
    }

    public void print(){
        for (Horse h : getHorses()){
            h.print();
        }
        for (int i = 1; i < 11; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){

        HashMap<Double,Horse> map = new HashMap<>();

        for (Horse h : getHorses()){
            map.put(h.getDistance(),h);
        }
        double max = 0;
        for (Map.Entry<Double,Horse> m : map.entrySet()){
            if (m.getKey() > max){
                max = m.getKey();
            }
        }
        return map.get(max);
    }
    public void printWinner(){
        System.out.println("Winner is " +  getWinner().getName() + "!");
    }

}

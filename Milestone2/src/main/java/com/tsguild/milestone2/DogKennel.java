package com.tsguild.milestone2;

import java.awt.Color;

/**
 *
 * @author souldj673
 */
public class DogKennel {

    public static void main(String[] args) {
        Dog charles;
        charles = new Dog();
        System.out.println("WE HAVE CHARLES!");
        System.out.println("This is his name: " + charles.getName());

        //New Dog :0
        Dog jeff;
        jeff = new Dog("Jeff", 69.0, 7, Color.BLACK, Trick[0]);
        System.out.println("New Doggo :)");
        System.out.println("This is his name: " + jeff.getName());
    }
}

package com.tsguild.milestone2.codealong.dog;

/**
 *
 * @author souldj673
 */
public class DogKennel {

    public static void main(String[] args) {
        Dog charlesDog;
        charlesDog = new Dog();
        System.out.println("WE HAVE CHARLES!");
        System.out.println("This is his name: " + charlesDog.getName());
        System.out.println("");

        //New Dog :0
        Dog jeffDog;
        jeffDog = new Dog("Jeff", 69.0, 7);
        System.out.println("New Doggo :)");
        System.out.println("This is his name: " + jeffDog.getName());
        System.out.println("");

        //New Dog :0
        Dog sushiDog;
        sushiDog = new Dog("Sushi", 55.0, 8);
        System.out.println("New Doggo :)");
        System.out.println("This is her name: " + sushiDog.getName());
        System.out.println("She is " + sushiDog.getAge() + " and weighs " + sushiDog.getWeight() + ".");
        System.out.println("");
        System.out.println("Hello Sushi!");
        sushiDog.bark();
    }
}

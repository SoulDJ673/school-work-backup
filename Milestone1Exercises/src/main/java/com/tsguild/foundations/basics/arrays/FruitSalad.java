package com.tsguild.foundations.basics.arrays;

/**
 *
 * @author souldj673
 */
public class FruitSalad {

    /*
    As many berries as possible
    No more than 3 kinds of apples
    No more than 2 kinds of orange
    Definitely no tomatoes
    More than 12 kinds of fruit isn't recommended
     */
    public static void main(String[] args) {
        //Array Declare/Init
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple", "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};

        //Sort Fruits into Salad
        String[] fruitSalad = saladCreator(fruit);

        //Print Fruit Salad Info
        System.out.println("There are " + fruitSalad.length + " fruits in the salad!");
        System.out.print("The fruits are: ");
        for (int i = 0; i < fruitSalad.length; i++) {
            System.out.print(fruitSalad[i] + ", ");
        }

    }

    public static String[] saladCreator(String[] fruit) {
        //Declare & Initialize Fruit Salad Array
        String[] fruitSalad = new String[12];

        //Tracker Variables
        int apples = 0;
        int oranges = 0;

        //Remember place in salad array
        int nextAvailableSpace = 0;

        //Run through fruits and pick out all the berries first
        for (int i = 0; i < fruit.length; i++) {
            if (fruit[i].contains("berry") && nextAvailableSpace < fruitSalad.length) {
                fruitSalad[nextAvailableSpace] = fruit[i];
                nextAvailableSpace++;
            } else {
            }
        }
        //Run through fruits and pick out the remaining ones that qualify for the salad
        for (int i = 0; i < fruit.length; i++) {
            if (fruit[i].contains("Apple") && apples < 3 && nextAvailableSpace < fruitSalad.length) { //Apples must be no greater than 3 and the salad array must not be full
                fruitSalad[nextAvailableSpace] = fruit[i];
                apples++;
                nextAvailableSpace++;
            } else if (fruit[i].contains("Orange") && oranges < 2 && nextAvailableSpace < fruitSalad.length) { //Oranges must be no greater than 2 and the salad array must not be full
                fruitSalad[nextAvailableSpace] = fruit[i];
                oranges++;
                nextAvailableSpace++;
            } else if (!fruit[i].contains("Tomato") && nextAvailableSpace < fruitSalad.length) { //Anything that doesn't contain "Tomato" can be added to the salad as long as the salad isn't full
                fruitSalad[nextAvailableSpace] = fruit[i];
                nextAvailableSpace++;
            } else if (nextAvailableSpace >= fruitSalad.length) { //Break out of the loop if the salad is full
                break;
            }
        }

        return fruitSalad;
    }

}

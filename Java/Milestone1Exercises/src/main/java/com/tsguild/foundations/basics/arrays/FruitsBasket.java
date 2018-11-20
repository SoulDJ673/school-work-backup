package com.tsguild.foundations.basics.arrays;

/**
 *
 * @author souldj673
 */
public class FruitsBasket {

    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        String[] apples = new String[fruit.length];
        int appleBasketPlace = 0;
        String[] oranges = new String[fruit.length];
        int orangeBasketPlace = 0;

        System.out.println("Total # of fruit in basket: " + fruit.length);

        //Fruit Sorting
        for (int i = 0; i < fruit.length; i++) {
            if ("Orange".equals(fruit[i])) {
                oranges[orangeBasketPlace] = "Orange";
                orangeBasketPlace++;
            } else {
                apples[appleBasketPlace] = "Apple";
                appleBasketPlace++;
            }
        }
        System.out.println("There are " + (appleBasketPlace) + " apples.");
        System.out.println("There are " + (orangeBasketPlace) + " oranges.");
    }

}

package com.tsguild.milestone2.codealong.methods;

/**
 *
 * @author souldj673
 */
public class UsingMethods {

    public static void main(String[] args) {
        //Summon Color Method 1 to Print Green
        System.out.println("Method 1 - OwO");
        String color = StaticMethods.colorThingOne("OwO");
        System.out.println(color);
        
        //Spacing to make things nicer to look at
        System.out.println("");
        
        //Summon Color Method 1 to Print Blue
        System.out.println("Method 1 - Red");
        color = StaticMethods.colorThingOne("red");
        System.out.println(color);
        
        System.out.println("");
        
        //Summon Highest Number Method to Print Highest Number
        System.out.println("Method highestNum - 3, 2, 4");
        int bigNum = StaticMethods.highestNum(3, 2, 4);
        System.out.println(bigNum + " is the largest number.");
    }
}

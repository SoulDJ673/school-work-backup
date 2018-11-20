package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Random;

/**
 *
 * @author souldj673
 */
public class LazyTeenager {

    public static void main(String[] args) {
        //Variable Declare/Init
        boolean responsibility;
        int timesTold = 1;

        do {
            System.out.println("Clean your room! (x" + timesTold + ")");
            responsibility = responsibilityCheck(timesTold);
            timesTold++;
        } while (!responsibility && timesTold < 15);
        
        if (timesTold >= 15) {
            System.out.println(timesTold + " TIMES?!?!?! THAT IS IT, YOU'RE GROUNDED!!!");
        } else {
            System.out.println("UGH FINNNNEEE... I'LL NEVER STOP eating sugar(?) THOUGH!!!");
        }
    }

    //Random Chance
    public static boolean responsibilityCheck(int timesTold) {
        //Random, Var Declare/Init
        Random chance = new Random();
        int cleanNumber;

        //Pick Number
        cleanNumber = chance.nextInt(100);

        //Use Number and chance % to determine whether or not the room will be cleaned
        //When cleanNumber falls between 0 and the percent, the room will be cleaned 
        return cleanNumber <= (timesTold * 5);
    }
}

package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Random;

/**
 *
 * @author souldj673
 */
public class MaybeItLovesMe {

    public static void main(String[] args) {
        //Random, Variable Declare/Init
        Random emotionalStability = new Random();
        int petalsTotal;
        int petalsPicked = 0;
        boolean love = false;

        do { //Do-while because petalsTotal must have a value before the condition can be checked
            petalsTotal = emotionalStability.nextInt(89);
        } while (petalsTotal > 89 && petalsTotal < 13);

        //Picking Petals
        while (petalsPicked < 34) {
            if (!love) {
                System.out.println("It loves me NOT!");
                petalsPicked++;
                love = true;
            } else {
                System.out.println("It LOVES me!");
                petalsPicked++;
                love = false;
            }
        }

        //Print Final
        if (!love) { //Love is inverted because of how my if/else statements are set up.  Because love is inversed at the end of the scopes (Loves me is inversed to false; Loves me not is inverted to true;), this must also be inversed to print the correct endings
            System.out.println("I knew it! It LOVES ME!");
        } else {
            System.out.println("I knew it. I'm just a friend. V_V");
        }
    }
}
/*
I used a while loop because I prefer them over do whiles, and also I didn't have a
particular need to check the condition after the loop has occured.
*/

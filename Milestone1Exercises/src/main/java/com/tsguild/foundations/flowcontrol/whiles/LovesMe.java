package com.tsguild.foundations.flowcontrol.whiles;

/**
 *
 * @author souldj673
 */
public class LovesMe {

    public static void main(String[] args) {
        //Variable Declare/Init
        int petals = 0;
        boolean love = false;

        //Picking Petals
        while (petals < 34) {
            if (!love) {
                System.out.println("It loves me NOT!");
                petals++;
                love = true;
            } else {
                System.out.println("It LOVES me!");
                petals++;
                love = false;
            }
        }
        
        //Print Final
        if(!love){ //Love is inverted because of how my if/else statements are set up.  Because love is inversed at the end of the scopes (Loves me is inversed to false; Loves me not is inverted to true;), this must also be inversed to print the correct endings
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
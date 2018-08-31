package com.tsguild.foundations.flowcontrol.ifs;

/**
 *
 * @author souldj673
 */
public class SpaceRustlers {

    public static void main(String[] args) {

        int spaceships = 10;
        int aliens = 25;
        int cows = 100;

        if (aliens > spaceships) {
            System.out.println("Vrroom, vroom! Let's get going!");
        } else {
            System.out.println("There aren't enough green guys to drive these ships!");
        }

        if (cows == spaceships) { //If the condition(s) inside the parenthesis are met, then the code inside the corresponding scope will be executed
            System.out.println("Wow, way to plan ahead!"
                    + " JUST enough room for all these walking hamburgers!");
        } else if (cows > spaceships) { //This acts like a normal else except it has specific conditions.  This will execute only if the preceeding if statement's conditions aren't met (and it's own conditions are met, of course).  If else is removed, the statement will execute if the conditions are met even if the preceeding if statement also executes.
            System.out.println("Dangit! I don't how we're going to fit all"
                    + " these cows in here!");
        } else {
            System.out.println("Too many ships! Not enough cows.");
        }

        //Hamburger Party
        if (cows < aliens) {
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");
        } else if (cows >= aliens) {
            System.out.println("Oh no! The herds got restless and took over! Looks like _we're_ hamburger now!!");
        }
    }
}

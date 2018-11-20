package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class MiniZork {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places?"
                            + " Not a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields... "
                            + "looking VERY foolish.");
                    System.out.println("But you live. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {
                System.out.println("You stick your hand in the mailbox.");
                System.out.println("You really shouldn't have done that.");
                System.out.println("You feel something alive in the mailbox.");
                System.out.print("Pull your hand out or slam your hand against the insides of the mailbox?");

                if (action.equals("pull hand out")) {
                    System.out.println("It's too late for that.");
                    System.out.println("You've been pulled into the box and eaten alive.");
                    System.out.println("Good job.");
                } else if (action.equals("slam hand against the insides of the mailbox")) {
                    System.out.println("Your panicking has crushed and killed whatever was in there.");
                    System.out.println("You run away screaming.  You really need a hobby.");
                }
            }
        } else if (action.equals("go to the house")) {
            System.out.println("You tear the boards off the door enter the house.");
            System.out.println("It reeks of cheese, weird.");
            System.out.println("You hear someone singing strange songs of macaroni from the kitchen.");
            System.out.print("Investigate the kitchen or stay put? ");
            action = userInput.nextLine();

            if (action.equals("investigate")) {
                System.out.println("You go to investigate and you find a dirty man making a pot of Mac n' Cheese.");
                System.out.println("He sees you, and grabs a knife.  He's clearly insane.");
                System.out.println("He asks if you're here to steal his gold, and you catch eye of a gallon of milk.");
                System.out.print("Are you stealing his 'gold' or not? ");
                action = userInput.nextLine();

                if (action.equals("stealing his gold")) {
                    System.out.println("The man screams 'I KNEW IT!!!!' before frantically arguing with himself and beginning to fidget.");
                    System.out.println("You take this opportunity to try to escape, but before you can leave the man throws his knife into your torso, killing you.");
                } else if (action.equals("not")) {
                    System.out.println("In a panic, you assure him that you weren't stealing from him.");
                    System.out.println("You convince him to let you get up, and you grab the milk. Still cold.");
                    System.out.println("Because he's insane, you try convincing him that you brought the milk as a gift.");
                    System.out.println("Suprisingly this works, and he thanks you.  He begins to tell you about how he actually needed milk, he's making Mac n' Cheese.");
                    System.out.println("You already know this, but you play along to save your life.  He ends up offering you a bowl, you accept to appease him, and you leave in one piece.");
                }

            } else if (action.equals("stay put")) {
                System.out.println("You freeze.");
                System.out.println("A madman leaves the kitchen, he heard you.");
                System.out.println("He's almost to where you're at, and there's a pile of boxes nearby.");
                System.out.print("Will you run out of the front door behind you, or hide behind the boxes? ");
                action = userInput.nextLine();

                if (action.equals("run out of the front door")) {
                    System.out.println("The door is loud, and gives away your location and motives.");
                    System.out.println("While you run, you see the crazy man has a strange weapon.");
                    System.out.println("Before you can figure out what it is, you feel a sharp pain in your leg.");
                    System.out.println("You fall to the ground, paralyzed.  Reality is fading out as you feel your life slipping away.");
                    System.out.println("You've died.");
                } else if (action.equals("hide behind the boxes")) {
                    System.out.println("You dive behind the boxes.");
                    System.out.println("The madman runs to the door, looks around, then moves on to the rest of the house.");
                    System.out.println("You wait for a while before the man comes back, then leaves back to the kitchen.");
                    System.out.println("You then sneak out from behind the boxes to a broken, partially boarded window.");
                    System.out.println("You're able to fit through the boards and escape.  As you do this, you're startled");
                    System.out.println("when you hear 'NOOOOOO, MY NOODLESSS!!!! THEY'RE RUINED!!!'  You shake that off and continue your escape.");
                    System.out.println("Success.  You escape and live to tell the tale.");
                }
            }
        }
    }
}

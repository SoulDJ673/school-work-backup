package com.tsguild.milestone2.challenge.goblinrpg;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class GoblinDungeonGame {

    //Class accessible Random & Scanner - Properties
    public static Random entropy;
    public static Scanner userInput;

    public static void main(String[] args) {
        //Random & Scanner Init + Variable Init
        entropy = new Random();
        userInput = new Scanner(System.in);
        int floors = 5;
        int steps = 10;
        boolean keepPlaying = true;

        //Welcome Banner Print
        welcomeBanner();

        //Making a Goblin
        Goblin player = makeNewGoblin();

        //Game Start
        floorLoop:                      //Outer loop per floor
        while (keepPlaying) {
            floorInfo(player, floors);  //Print Floor & Health

            //Fight a monster every step            
            stepLoop:                   //Inner loop for steps
            for (int i = 0; i < steps; i++) {
                Monster foe = makeNewMonster();
                System.out.println("Let's get out of here!!!");
                System.out.println("AAAHHHH " + player.getName() + ", there's a " + foe.getName() + "!");
                System.out.println("KILL IT!!! >w<");

                //Fight
                boolean didIWin = fight(player, foe);
                if (didIWin) { //Win
                    System.out.println("Let's rest uwu");
                    int goblinHealth = player.getHealth();
                    player.setHealth(goblinHealth++);
                } else { //Lost
                    break floorLoop;
                }
            }

            //Last floor check
            System.out.println("We made it to the stairs!!! ^w^");
            System.out.println("Let's see what's down there " + player.getName() + "uu!");
            if (floors > 1) {
                System.out.println("Aww, you've got another floor to do >w<");
                System.out.println("You can do it " + player.getName() + "uuu!!!!");
                floors--;
            } else {
                System.out.println("YAAAYY ^w^ WE DID IT " + player.getName() + "UU!!!");
            }

            //Win / Loss Message
            if (!isDead(player)) {
                System.out.println("YOU WINNN!!!!!");
            } else {
                System.out.println("YOU LOSE!!!!");
            }
        }
    }

    public static void welcomeBanner() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>  Hewwo!!! ^w^ Welcome to the Dungeonu!!!  >>>");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    //Goblin Factory
    public static Goblin makeNewGoblin() {
        //Name prompt
        System.out.println("What's ur namu?? uwu");
        String goblinName = userInput.nextLine();

        //Goblin Constructor Call
        Goblin ourHero = new Goblin(goblinName);
        return ourHero;
    }

    //Monster Factory
    public static Monster makeNewMonster() {
        int randomNum = entropy.nextInt(5); //range: 0-4
        Monster enemy = null;

        //Monster Variants
        switch (randomNum) {
            case 0: //Giant Bumblebee
            case 1: //Also Bee
                enemy = new Monster();
                enemy.setName("Giant Bumblebee");
                enemy.setDescription("An enormous buzzing bee");
                enemy.setExperience(10);
                enemy.setHealth(5);
                break;

            case 2: //Evil Spider
            case 3: //Also Spider
                enemy = new Monster();
                enemy.setName("Ewwy Spider");
                enemy.setDescription("An icky ewwy spider");
                enemy.setExperience(5);
                enemy.setHealth(2);
                break;

            default:
                enemy = new Monster();
        }
        return enemy;
    }

    //Damaging Maths
    public static boolean fight(Goblin hero, Monster foe) {
        //Keep fighting while both are alive
        while (!isDead(hero) && !isDead(foe)) {
            int heroDamage = entropy.nextInt(5) + 1;
            int foeDamage = entropy.nextInt(2) + 1;

            //Print Results
            System.out.println(hero.getName() + "uu, you've struck for " + heroDamage + "!!!");
            System.out.println("AAHHH You've been attacked for " + foeDamage + "!!");
            System.out.println("");

            //Hero health deductions
            int heroHealth = hero.getHealth();
            heroHealth = heroHealth - foeDamage;
            hero.setHealth(heroHealth);

            //Foe Health deductions
            int foeHealth = foe.getHealth();
            foeHealth = foeHealth - heroDamage;
            foe.setHealth(foeHealth);

            System.out.println("");
            System.out.println(">>> Pres Enter when you're ready to go ^w^ <<<");
            userInput.nextLine();
        }
        //Win Message
        if (!isDead(hero) && isDead(foe)) {
            System.out.println("WE DID IT!!!");
            return true;
        } else { //Loss message
            System.out.println("NUUUU!!!!! UwU");
            System.out.println("I'll miss u " + hero.getName() + "uu... UwU");
            return false;
        }
    }

    //Calls and Prints Health and Floor
    public static void floorInfo(Goblin hero, int floorsLeft) {
        System.out.println("We're on floor " + floorsLeft);
        System.out.println(hero.getName() + "u, you have " + hero.getHealth() + " health left!");
        System.out.println(">>> Pres Enter when you're ready to go ^w^ <<<");
        userInput.nextLine();
    }

    //Grim Reaper Methods (Check if Dead)
    public static boolean isDead(Goblin hero) {
        //Store user health into variable for comparison
        int health = hero.getHealth();
        if (health < 1) {                    //Comparison
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDead(Monster foe) {
        //Store monster health into variable for comparison
        int health = foe.getHealth();
        if (health < 1) {                    //Comparison
            return true;
        } else {
            return false;
        }
    }

}

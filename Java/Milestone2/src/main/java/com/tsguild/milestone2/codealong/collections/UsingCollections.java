package com.tsguild.milestone2.codealong.collections;

import com.tsguild.milestone2.challenge.goblinrpg.Goblin;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class UsingCollections {

    public static void main(String[] args) {
        //List (ArrayList) of Everyone's names
        ArrayList<String> classNames;
        classNames = new ArrayList<>();

        //Add my name to the Array List
        classNames.add("Devin");

        //Print Array List Size
        System.out.println("There is " + classNames.size() + " name in this array list.");
        System.out.println("");

        //Add Everyone else's names
        classNames.add("Anthony");
        classNames.add("TJ");
        classNames.add("Nathanael");
        classNames.add("Josh");
        classNames.add("Brady");
        classNames.add("James");
        classNames.add("Ty");
        classNames.add("Keegan");
        classNames.add("Kavont");
        classNames.add("Austyn");
        classNames.add("Kate");

        //Print new size
        System.out.println("I've added some more!");
        System.out.println("There are now " + classNames.size() + " names in the array list:");

        //Print all names in the array list
        for (int i = 0; i < classNames.size(); i++) {
            System.out.println(classNames.get(i));
        }

        System.out.println("");

        //Print every other name in the array list
        System.out.println("Every other name!");
        for (int i = 0; i < classNames.size(); i += 2) {
            System.out.println(classNames.get(i));
        }

        System.out.println("");

        //Enhanced for loop
        //for (Type item : groupName) {}
        System.out.println("Every name with enhanced for loop!");
        for (String name : classNames) {
            System.out.println(name);
        }

        System.out.println("");

        //List of Goblins
        List<Goblin> someGobbos = new ArrayList<>();

        //Create and add Bob via constructor and .add
        Goblin goblinBob = new Goblin("Bob");
        someGobbos.add(goblinBob);

        //Construct and add simultaneously
        someGobbos.add(new Goblin("Mary Sue"));
        someGobbos.add(new Goblin("Jeff"));
        someGobbos.add(new Goblin("Sir Owo"));
        someGobbos.add(new Goblin("Billy Herrington"));
        someGobbos.add(new Goblin("Sue Mi"));

        System.out.println("There are " + someGobbos.size() + " goblins in the list");
        System.out.println("Their names are: ");
        for (Goblin goblins : someGobbos) {
            System.out.println(goblins.getName());
        }

        System.out.println("");

        //Print out names of Goblins with names longer than 4 characters
        System.out.println("Print out names of goblins that are longer than 4 characters");
        for (Goblin goblins : someGobbos) {
            String name = goblins.getName();
            if (name.length() > 4) {
                System.out.println(goblins.getName());
            }
        }
    }
}

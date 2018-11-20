package com.tsguild.milestone2.classwork.llamaclassdiagram;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class LlamaPen {

    public static void main(String[] args) {

        //Build no args Llama - Jeff
        Llama jeff = new Llama();
        jeff.setName("Jeff");

        //Build all args Llama - Ligma
        Llama ligma = new Llama(3, 5, "Spikey", "Black", "Ligma");

        //Context + Print Jeff and Ligma Info to Console - Attendence
        System.out.println("Llama Pen Attendence");
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        llamaRosterGenerator(jeff);
        llamaRosterGenerator(ligma);

        //User Llama Generation
        Llama userLlama = new Llama();
        userLlamaGen(userLlama);

        //Print Updated Attendence
        System.out.println("Llama Pen Attendence");
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        llamaRosterGenerator(jeff);
        llamaRosterGenerator(ligma);
        llamaRosterGenerator(userLlama);

        //FrankenLlama - 5 legs, Jeff's Wool Type, userLlama's Wool Color, Ligma's Age
        Llama frankenLlama = new Llama();
        frankenLlama.setName("FrankenLlama");
        frankenLlama.setNumLegs(5);
        frankenLlama.setYearsOld(ligma.getYearsOld());
        frankenLlama.setWoolType(jeff.getWoolType());
        frankenLlama.setWoolColor(userLlama.getWoolColor());

        //Print FrankenLlama Info
        System.out.println("Ooooh, a FrankenLlama!");
        System.out.println("");
        llamaRosterGenerator(frankenLlama);
    }

    public static void llamaRosterGenerator(Llama looma) {
        System.out.println(looma.getName() + ":");
        System.out.println(looma.getNumLegs() + " Legs");
        System.out.println(looma.getYearsOld() + " Years Old");
        System.out.println(looma.getWoolType() + " " + looma.getWoolColor() + " Wool");

        System.out.println("");
    }

    public static void userLlamaGen(Llama userLlama) {
        //Scanner Setup
        Scanner userInput = new Scanner(System.in);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //User Generated Llama
        System.out.println("> Oh?  What is this?  A new Llama?");
        System.out.println("> What is it's name?");
        userLlama.setName(userInput.next());

        System.out.println("");
        System.out.println("> " + userLlama.getName() + "?  Wonderful!  I'll write that down.");
        System.out.println("> What is it's age?");
        userLlama.setYearsOld(userInput.nextInt());

        System.out.println("");
        System.out.println("> Awesome! How many legs does it have?");
        userLlama.setNumLegs(userInput.nextInt());

        System.out.println("");
        System.out.println("> Okay, what is it's legal color?");
        userLlama.setWoolColor(userInput.next());

        System.out.println("");
        System.out.println("> Yep, yep. Lastly, what is it's wool type?");
        userLlama.setWoolType(userInput.next());

        System.out.println("> Awesome!!! " + userLlama.getName() + " is now on the attendance roster.");
        System.out.println("> Take a look: ");

        System.out.println("");
    }
}

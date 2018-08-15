/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.scanner;

import java.util.Scanner;
/**
 *
 * @author souldj673
 */
public class DoItBetter {
    public static void main(String[] args) {
        //Input setup
        int userAccomplishment;
        Scanner userInput = new Scanner(System.in);
        
        //Ego Start
        System.out.println("Hello! Let's see how pathetic you are! :)");
        
        System.out.print("How many whole miles can you run? [must be an integer]: ");
        userAccomplishment = userInput.nextInt();
        System.out.println("Ha! You suck! I can run " + ((userAccomplishment * 2) + 1) + "!");
        
        System.out.print("How many consecutive [whole] hot dogs can you eat? [integer]: ");
        userAccomplishment = userInput.nextInt();
        System.out.println("Ha! You suck! I can eat " + ((userAccomplishment * 2) + 1) + "!");
        
        System.out.print("How many languages can you speak? ");
        userAccomplishment = userInput.nextInt();
        System.out.println("Ha! You suck! I can speak " + ((userAccomplishment * 2) + 1) + "!");
    }
    
}

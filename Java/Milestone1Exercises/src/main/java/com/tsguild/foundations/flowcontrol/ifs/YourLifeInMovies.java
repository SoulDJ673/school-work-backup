/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;
/**
 *
 * @author souldj673
 */
public class YourLifeInMovies {
    public static void main(String[] args) {
        //Variable and Input Setup
        int userYear;
        Scanner userInput = new Scanner(System.in);
        
        //Program Start
        System.out.println("Wanna feel old? Too bad, I'm gonna do it anyway.");
        System.out.print("When were you born?: ");
        userYear = userInput.nextInt();
        System.out.println("Well...");
        
        //If Statements
        if(userYear < 2005) {
            System.out.println("Did you know that Pixar's 'Up' came out half a decade ago?");
        } else {
            System.out.println("Wow, you're a baby. I'd make fun of you but I'm sure you'd cry.");
            System.out.println("Try coming back in a few years.");
            return;
        }
        if(userYear < 1995) {
            System.out.println("And that the first Harry Potter came out over 15 years ago!");
        }
        if(userYear < 1985) {
            System.out.println("Also, Space Jam came out not last decade, but the one before THAT.");
        }
        if(userYear < 1975) {
            System.out.println("Don't forget that the original Jurassic Park release is closer to the lunar landing, than today.");
        }
        if(userYear < 1965) {
            System.out.println("Lastly, MASH has been around for almost half a century!");
        }
        
        //Closing
        System.out.println("Feel old yet? I hope so. Thanks for playing!");
    }
}

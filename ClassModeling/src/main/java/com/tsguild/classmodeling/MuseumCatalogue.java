package com.tsguild.classmodeling;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class MuseumCatalogue {

    //Properties
    private static Painting painting;
    private static Painting[] catalogue = new Painting[100];
    
    //Populate the catalogue
    public static void census() {
        Painting jey = new Painting("Dog", "Doge isn't Funny Anymore", "Funny Haha Meme Lord", 69);
        jey = catalogue[0];
    }

    //User Navigation
    public static void main(String[] args) {
        //Populate Array
        census();
        
        //Variables, Scanner Declaration & Stuff
        int location;
        Scanner userChoice = new Scanner(System.in);

        System.out.println("  Museum Catalogue  ");
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        System.out.println("");
        System.out.println("Which painting would you like to view today? (Give Location [interger]):");
        location = userChoice.nextInt();
        displayPainting(location);
        
    }

    //Logical Methods
    //NO Args, Display all paintings in catalogue
    public static void displayPainting() {
        System.out.println("\nNo location given.  Displaying all paintings.\n");
        for (int i = 0; i < catalogue.length; i++) {
            System.out.println(catalogue[i].getName());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Subject: " + catalogue[i].getSubject());
            System.out.println("Artist: " + catalogue[i].getArtistName());
            System.out.println("Date: " + catalogue[i].getDate());
        }
    }

    //Location given, display specific painting
    public static void displayPainting(int location) {
        System.out.println("");
        System.out.println(catalogue[location].getName());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Subject: " + catalogue[location].getSubject());
        System.out.println("Artist: " + catalogue[location].getArtistName());
        System.out.println("Date: " + catalogue[location].getDate());
    }

    public static void addPainting() {

    }
}

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
    public static Painting census() {
        Painting jey = new Painting("Dog", "Doge isn't Funny Anymore", "Funny Haha Meme Lord", 69);
        catalogue[0] = jey;
        return jey;
    }

    //User Navigation
    public static void main(String[] args) {
        //Populate Array
        census();

        //Variables, Scanner Declaration & Stuff
        boolean valid = false;
        String location;
        Scanner userChoice = new Scanner(System.in);

        System.out.println("  Museum Catalogue  ");
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        System.out.println("");
        System.out.println("Which painting would you like to view today?");
        System.out.println("(Give Location [integer] or type 'new' to add a new painting");
        System.out.println("OR 'search' to show all paintings that meet a specific criteria.)");

        //Input and Validation
        while (valid == false) {
            location = userChoice.nextLine();

            //Input Validation
            try {
                if (location.equalsIgnoreCase("new")) {
                    addPainting();
                    valid = true;
                    return;
                }
                if (Integer.parseInt(location) < catalogue.length && Integer.parseInt(location) >= 0) {
                    displayPainting(Integer.parseInt(location));
                    valid = true;
                    return;
                } else {
                    displayPainting();
                    valid = true;
                    return;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid option...");
            }
        }

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

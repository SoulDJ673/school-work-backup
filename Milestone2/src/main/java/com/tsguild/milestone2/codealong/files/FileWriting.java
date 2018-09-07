package com.tsguild.milestone2.codealong.files;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class FileWriting {

    //Class Accessible Llama Pen
    public static List<Llama> llamaHerd = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //Construct some Llamas
        Llama jeff = new Llama("Jeff", "Blue", "Spiky", 7, 7.0, true);
        Llama lobster = new Llama("Lobster", "Red", "Fluffy", 5, 3.0, false);
        Llama shrek = new Llama("Shrek", "Green", "Fuzzy", 13, 5.0, true);
        Llama haramboi = new Llama("xXHaramboi69XD", "Black", "Fluffy", 69, 14.0, false);
        Llama goat = new Llama("Goat", "White", "Fuzzy", 9, 6.0, false);

        //Add them to the llamaHerd arraylist
        llamaHerd.add(jeff);
        llamaHerd.add(lobster);
        llamaHerd.add(shrek);
        llamaHerd.add(haramboi);
        llamaHerd.add(goat);

        //Add some more llamas to the Herd directly
        llamaHerd.add(new Llama("Serrano", "Dark Brown", "Sorta Fluffy", 12, 33.0, true));
        llamaHerd.add(new Llama("Dixie", "Dark Brown", "Fluffy", 8, 35.0, false));

        // This won't work because Llamas are complex objects
        //System.out.println("lol " + jeff);
        // This will though - This calls our mashalling method to turn Jeff's properties into a printable string
        System.out.println("Let's call for our first Llama!");
        System.out.println("A Llama: " + marshallLlama(jeff) + "\n");

        //Iterating over the Herd
        System.out.println("Now for the whole herd!");
        for (Llama llama : llamaHerd) {
            System.out.println("A llama: " + marshallLlama(llama));
        }

        //Now to write our herd to a file!
        String fileName = "llamaHerd.txt";
        //for now just throw the exception
        FileWriter fileWriter = new FileWriter(fileName);

        //Now we'll setup a PrintWriter
        PrintWriter printWriter = new PrintWriter(fileWriter);

        //Now borrow the for loop from above:
        for (Llama llama : llamaHerd) {
            printWriter.println(marshallLlama(llama));
        }

        //Make sure the file is written before program dies
        printWriter.flush();
        printWriter.close();
    }

    //Turn Llama into something we can store in a file (Marshalling)
    public static String marshallLlama(Llama aLlama) {
        String delimiter = "::";
        String llamaLine = aLlama.getName() + delimiter;
        llamaLine = llamaLine + aLlama.getWoolColor() + delimiter;
        llamaLine = llamaLine + aLlama.getWoolType() + delimiter;
        llamaLine = llamaLine + aLlama.getAge() + delimiter;
        llamaLine = llamaLine + aLlama.getWoolLength() + delimiter;
        llamaLine = llamaLine + aLlama.isCanDrive();

        return llamaLine;
    }
}

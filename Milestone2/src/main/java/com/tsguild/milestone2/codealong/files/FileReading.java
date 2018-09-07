package com.tsguild.milestone2.codealong.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class FileReading {

    public static void main(String[] args) throws FileNotFoundException {
        //Individual Llama Line
        String llamaAsString = "Jeff::Blue::Spiky::7::7.0::true";
        Llama jeff = unmarshallLlama(llamaAsString);
        System.out.println("Jeff is back lol.\n");

        //Getting the llamaHerd back together
        List<Llama> llamaHerd = new ArrayList<>();

        //Mass resurrection
        //Finding the file
        String fileName = "llamaHerd.txt";
        FileReader fileReader = new FileReader(fileName);

        //Reading the file
        BufferedReader reader = new BufferedReader(fileReader);

        //File Parsing
        Scanner scanner = new Scanner(reader);

        //File Iteration
        while (scanner.hasNextLine()) {
            String llamaLine = scanner.nextLine();
            Llama theLlama = unmarshallLlama(llamaLine);
            llamaHerd.add(theLlama);
        }

        //Kill scanner
        scanner.close();

        //Print Herd size and llama names
        System.out.println("I read the file! I found: " + llamaHerd.size() + " llamas in it!");
        System.out.println("Their names are: ");
        for (Llama llama : llamaHerd) {
            System.out.print(llama.getName() + ", ");
        }
    }

//Recreate Llamas from our marshalled LlamaHerd (Unmarshalling)
    public static Llama unmarshallLlama(String llamaAsString) {

        //Marshalled Llama order        
        //name::woolColor::woolType::age::woolLength::canDrive
        Llama aNewLlama = new Llama();
        String delimiter = "::";

        //Split Llama Lines into Separate array values
        String[] llamaBits = llamaAsString.split(delimiter);

        //Use separated llama property values with setters to recreate our llama(s)
        aNewLlama.setName(llamaBits[0]);
        aNewLlama.setWoolColor(llamaBits[1]);
        aNewLlama.setWoolType(llamaBits[2]);

        //Non-String values must be parsed
        aNewLlama.setAge(Integer.parseInt(llamaBits[3]));
        aNewLlama.setWoolLength(Double.parseDouble(llamaBits[4]));
        aNewLlama.setCanDrive(Boolean.parseBoolean(llamaBits[5]));

        return aNewLlama;
    }
}

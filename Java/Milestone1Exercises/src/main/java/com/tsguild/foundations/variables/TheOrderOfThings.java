package com.tsguild.foundations.variables;

/**
 *
 * @author souldj673
 */
public class TheOrderOfThings {

    public static void main(String[] args) {

        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;

        number = 5.0;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "BRIGHT yellow";
        origin = "AlphaCentaurian";
        material = "platinum";
        purpose = "good";

        noun = "dragons";

        // Using the + with strings, doesn't add it concatenates! (sticks them together)
        System.out.println(number + " " + opinion + " " + size + " " + age + " " + shape + " " + color + " " + origin + " " + material + " " + purpose + " " + noun);

        //Other ways to arrange but still sound ok
        System.out.println(number + " " + age + " " + size + " " + purpose + " " + color + " " + shape + " " + opinion + " " + origin + " " + material + " " + noun);
        System.out.println(number + " " + purpose + " " + age + " " + size + " " + shape + " " + color + " " + opinion + " " + material + " " + origin + " " + noun);
    }
}

package com.tsguild.foundations.flowcontrol.whiles;

/**
 *
 * @author souldj673
 */
public class BewareTheKraken {

    public static void main(String[] args) {

        System.out.println("Already, get yer flippers & wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLOOSH*");

        int depthDivedInFt = 0;

        // The ocean is only so deep, 36200 at the deepest survey,
        // Stop at the bottom
        while (depthDivedInFt < 36200) {
            System.out.println("So far, we've swam " + depthDivedInFt + " feet");

            if (depthDivedInFt >= 20000) {
                System.out.println("OwO I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            // Fast Swimmer Owo
            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}

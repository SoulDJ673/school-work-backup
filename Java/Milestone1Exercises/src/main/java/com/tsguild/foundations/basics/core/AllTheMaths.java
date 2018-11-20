/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.core;

/**
 *
 * @author souldj673
 */
public class AllTheMaths {
    public static void main(String[] args) {
        System.out.print("1 + 2 is: ");
        System.out.println(1 + 2);
        
        System.out.print("42001 modulus 5 is: ");
        System.out.println(42001 % 5);
    
        System.out.print("5565.0 divided by 22.0 is: ");
        System.out.println(5565.0 / 22.0);
        
        System.out.print("223 times 31 minus 42 is: ");
        System.out.println(223 * 31 - 42);
        
        System.out.print("Is 4 greater than -1? ");
        System.out.println(4 > -1);
        
        //Bigger Calculations
        System.out.println("\n****** Now make the computer do some harder maths!");
        
        System.out.print("8043.52 minus 4.2 plus 23.0 divided by 56.0 times -76.13 is: ");
        System.out.println(8043.52 - 4.2 + 23.0 / 56.0 * -76.13);
        
        System.out.print("Is 67 greater than 4 * 5? ");
        System.out.println(67 > (4 * 5));
        
        System.out.print("Is 78 less than 4 * 5? ");
        System.out.println(78 < (4 * 5));
    }
}

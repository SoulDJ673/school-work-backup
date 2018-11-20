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
public class BiggerBetterAdder {
    public static void main(String[] args) {
        
        //Variable Declaration
        int first;
        int second;
        int third;
        int total;
        Scanner userInput = new Scanner(System.in);
        
        //Program Start
        System.out.print("The value of the first integer you want to add is: ");
        first = userInput.nextInt();
        
        System.out.println("The value of the second integer you want to add is: ");
        second = userInput.nextInt();
        
        System.out.println("The value of the third integer you want to add is: ");
        third = userInput.nextInt();
        
        total = first + second + third;
        System.out.println("They add up to equal: " + total);
        System.out.println("Again, the total is: " + total);
    }
    
}

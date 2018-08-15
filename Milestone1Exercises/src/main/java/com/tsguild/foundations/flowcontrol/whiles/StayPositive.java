/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Scanner;
/**
 *
 * @author souldj673
 */
public class StayPositive {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int base2 = 1;
        
        System.out.print("Pick a number to count down from: ");
        int userNum = userInput.nextInt();
        
        System.out.println("");
        System.out.println("Here we go!");
        
        while(userNum >= 0) {
            if(base2 == 10) {
                System.out.println(userNum + " ");
                userNum--; base2 = 1;
            } else {
                System.out.print(userNum + " ");
                userNum--; base2++;
            }
        }
    }
}

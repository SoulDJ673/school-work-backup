/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone3basics.datetimestuff.birthdaycalculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class BirthdayCalculator {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        LocalDate birthdayLD;
        LocalDate today = LocalDate.now();

        //Get Birthday from user
        System.out.print("When's your birthday (MM/dd/yyyy)? : ");
        String birthday = userInput.next();
        birthdayLD = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(birthdayLD);

        System.out.println("Your birthday was on " + birthdayLD.getDayOfWeek());

        //Next year birth day
        birthdayLD = birthdayLD.plusYears(1);
        System.out.println("On one year from now, your birthday will be on a " + birthdayLD.getDayOfWeek());
        birthdayLD = birthdayLD.minusYears(1);
        LocalDate bDayThisYear = birthdayLD.withYear(today.getYear());
        System.out.println("Your birthday this year is on a " + bDayThisYear.getDayOfWeek());
        System.out.println(bDayThisYear);

        int howManyDaysUntilNextBDay = bDayThisYear.getDayOfYear();
        int howLongUntilNextBDay;

        if (today.isLeapYear()) {
            LocalDate endOfYear = LocalDate.ofYearDay(2020, 366);
            int endToNow = endOfYear.getDayOfYear() - today.getDayOfYear();

            LocalDate startOfYear = LocalDate.ofYearDay(2020, 1);
            int startToThen = bDayThisYear.getDayOfYear() - startOfYear.getDayOfYear();

            howLongUntilNextBDay = startToThen + endToNow + 1;
            System.out.println("Today is " + today);
            System.out.println("Your birthday will be in " + howLongUntilNextBDay);
        } else {
            LocalDate endOfYear = LocalDate.ofYearDay(2018, 365);
            int endToNow = endOfYear.getDayOfYear() - today.getDayOfYear();

            LocalDate startOfYear = LocalDate.ofYearDay(2018, 1);
            int startToThen = bDayThisYear.getDayOfYear() - startOfYear.getDayOfYear();

            howLongUntilNextBDay = startToThen + endToNow + 1;
            System.out.println("Today is " + today);
            System.out.println("Your birthday will be in " + howLongUntilNextBDay + " days.");
        }
        if (howLongUntilNextBDay > 365) {
            int actualBDay = howLongUntilNextBDay - 365;
            System.out.println("Wait, that doesn't sound right.");
            System.out.println("Your birthday will actually be in " + actualBDay + " days.");
        }
        if (today.isBefore(bDayThisYear)) {

            int age = today.getYear() - birthdayLD.getYear() - 1;
            System.out.println("Your current age is " + age);
        } else {

            int age = today.getYear() - birthdayLD.getYear();
            System.out.println("Your current age is " + age);
        }
    }
}

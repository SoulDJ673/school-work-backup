/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BirthdayCalculator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author 19jriddell
 */
public class BirthdayCalculator {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        LocalDate calander;
        LocalDate today;
        String birthday;
        int howLongUntilNextBDay;

        System.out.println("When is your birthday? (MM/dd/yyyy)");
        today = LocalDate.now();
        birthday = userInput.next();
        calander = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(calander);

        System.out.println("Your birthday was on " + calander.getDayOfWeek());
        calander = calander.plusYears(1);
        System.out.println("On one year from now, your birthday will be on a " + calander.getDayOfWeek());
        calander = calander.minusYears(1);
        LocalDate bDayThisYear = calander.withYear(today.getYear());
        System.out.println("Your birthday this year is on a " + bDayThisYear.getDayOfWeek());
        System.out.println(bDayThisYear);

        int howManyDaysUntilNextBDay = bDayThisYear.getDayOfYear();

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
        if(howLongUntilNextBDay > 365){
        int actualBDay =  howLongUntilNextBDay - 365;
            System.out.println("Wait, that doesn't sound right.");
            System.out.println("Your birthday will actually be in " + actualBDay + " days.");
        }
        if (today.isBefore(bDayThisYear)) {
            
            int age = today.getYear() - calander.getYear() - 1;
            System.out.println("Your current age is " + age);
        } else {
            
            int age = today.getYear() - calander.getYear();
            System.out.println("Your current age is " + age);
        }
    }
}

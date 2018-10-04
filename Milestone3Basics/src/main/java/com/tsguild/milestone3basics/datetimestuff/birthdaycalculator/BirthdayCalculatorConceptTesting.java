package com.tsguild.milestone3basics.datetimestuff.birthdaycalculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class BirthdayCalculatorConceptTesting {

    private static Scanner userInput = new Scanner(System.in);
    private static DateTimeFormatter normal = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    private static LocalDate userBirthday;
    private static LocalDate today = LocalDate.now();

    public static void main(String[] args) {
        System.out.print("Test date: ");
        String dateString = userInput.next();
        userBirthday = userBirthday.parse(dateString, normal);
        String userBirthdayS = userBirthday.format(normal);

        System.out.println(userBirthdayS);

        System.out.println(userBirthday.getDayOfWeek());

        LocalDate userBDayThisYear = userBirthday.withYear(today.getYear());
        
        String upcomingBDay = userBDayThisYear.format(normal);
        System.out.println(upcomingBDay);
        
        int testNum = userBDayThisYear.getDayOfYear();
        System.out.println(testNum);
        int testNum2 = userBDayThisYear.withYear(2019).getDayOfYear();
        System.out.println(testNum);
        
        
    }

}

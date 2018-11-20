package com.tsguild.milestone3basics.datetimestuff;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author souldj673
 */
public class UsingDates {

    public static void main(String[] args) {
        LocalDate rightNow = LocalDate.now();
        System.out.println(rightNow);

        System.out.println("\nWith time!");
        LocalDateTime rightNowT = LocalDateTime.now();
        System.out.println(rightNowT);
        System.out.println("Hmm... this doesn't look so good...");

        System.out.println("\nLet's try to fix that with our own format!");
        DateTimeFormatter aBasicFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy @ HH:mm:ss");
        String nowString = rightNowT.format(aBasicFormat);
        System.out.println(nowString);

        System.out.println("\nJust the month now...");
        DateTimeFormatter justMonth = DateTimeFormatter.ofPattern("MM");
        String justMonthString = rightNowT.format(justMonth);
        System.out.println(justMonthString);

        System.out.println("The day after tomorrow...");
        rightNowT = rightNowT.plusDays(1);
        String rightNowTS = rightNowT.format(aBasicFormat);
        System.out.println(rightNowTS);
    }
}

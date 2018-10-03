package com.tsguild.milestone3basics.datetimestuff.simpletimer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author souldj673
 */
public class SimpleTimer {

    private LocalDateTime startTime;
    private LocalDateTime currentTime;
    private DateTimeFormatter basic = DateTimeFormatter.ofPattern("mm:ss");

    public SimpleTimer() {
    }

    public void countDownSeconds(int seconds) {
        startTime = startTime.now();
        int oldSecond = startTime.getSecond();
        int currentSecond = 0;

        //Timer Limit
        int count = 0;

        System.out.println("Starting at: " + startTime.format(basic));

        while (count < seconds) {
            currentTime = LocalDateTime.now();

            currentSecond = currentTime.getSecond();
            if (currentSecond != oldSecond) {
                System.out.println(currentTime.format(basic));
                count++;
            }
            oldSecond = currentSecond;
        }

        System.out.println("Time is up!!!");

    }

    public void countDownMinutes(double minutes) {
        startTime = startTime.now();
        int oldSecond = startTime.getSecond();
        int currentSecond = 0;

        //Timer Limit
        int count = 0;

        System.out.println("Starting at: " + startTime.format(basic));

        while (count < minutes * 60) {
            currentTime = LocalDateTime.now();

            currentSecond = currentTime.getSecond();
            if (currentSecond != oldSecond) {
                count++;
            } else if (count != 0 && count % 60 == 0) {
                System.out.println(currentTime.format(basic));
                count++;
            }
            oldSecond = currentSecond;

        }

        System.out.println("Time is up!!!");

    }
}

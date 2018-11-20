package com.tsguild.milestone3basics.datetimestuff.simpletimer;

/**
 *
 * @author souldj673
 */
public class SimpleTimerRun {
    public static void main(String[] args) {
        SimpleTimer timer = new SimpleTimer();
        
        System.out.println("=== 10 Second Timer === ");
        timer.countDownSeconds(10);
        
        System.out.println("=== 1 Minute Timer ===");
        timer.countDownMinutes(1);
    }
}

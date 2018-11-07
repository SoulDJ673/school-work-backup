/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.exercises.racer.tracks;

import com.tsguild.exercises.racer.helpers.RealAnnouncer;
import com.tsguild.exercises.racer.helpers.Mechanic;
import com.tsguild.exercises.racer.helpers.MumbleBot;
import com.tsguild.exercises.racer.interfaces.RaceAnnouncer;
import com.tsguild.exercises.racer.interfaces.Driveable;
import com.tsguild.exercises.racer.vehicles.exceptions.VehicleException;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author ahill
 */
public class Race {

    private int round = 0;
    private Driveable[] theRacers = new Driveable[6];
    private BigDecimal trackLength;
    private RaceAnnouncer raceAnnouncer = new MumbleBot();
    private Mechanic raceMechanic;

    public Race(String trackLength, RealAnnouncer raceAnnouncer) {
        this.trackLength = new BigDecimal(trackLength);
        this.raceAnnouncer = raceAnnouncer;
    }
    
    public Race(String trackLength) {
        this.trackLength = new BigDecimal(trackLength);
    }
    
    public void setMechanic(Mechanic raceMechanic){
        this.raceMechanic = raceMechanic;
    }

    /*
     ____   __    ___  ____  ____  ____ 
    (  _ \ / _\  / __)(  __)(  _ \/ ___)
     )   //    \( (__  ) _)  )   /\___ \
    (__\_)\_/\_/ \___)(____)(__\_)(____/

     */
    public void setFirstRacer(Driveable aRacer) {
        this.addRacer(0, aRacer);
    }

    public void setSecondRacer(Driveable aRacer) {
        this.addRacer(1, aRacer);
    }

    public void setThirdRacer(Driveable aRacer) {
        this.addRacer(2, aRacer);
    }

    public void setFourthRacer(Driveable aRacer) {
        this.addRacer(3, aRacer);
    }

    public void setFifthRacer(Driveable aRacer) {
        this.addRacer(4, aRacer);
    }

    public void setSixthRacer(Driveable aRacer) {
        this.addRacer(5, aRacer);
    }

    private void addRacer(int place, Driveable aRacer) {
        this.raceAnnouncer.announceRacerJoin(aRacer);
        this.theRacers[place] = aRacer;
    }

    /*
    ____   __    ___  __  __ _   ___ 
   (  _ \ / _\  / __)(  )(  ( \ / __)
    )   //    \( (__  )( /    /( (_ \
   (__\_)\_/\_/ \___)(__)\_)__) \___/
    
     */
    public void runRace() {
        this.raceAnnouncer.announceRace();
        this.reportRoundPlacings();
        while (!this.hasAWinner() && this.canSomeoneStillDrive() & this.round < 1000) {
            this.raceAnnouncer.announceRoundStart(round);
            this.driveRound();
            this.updateRound();
            this.pause();
        }
        this.endRace();
    }

    public void endRace() {
        Driveable winner = null;
        if (this.hasAWinner()) {
            winner = this.theRacers[0];
        }
        this.raceAnnouncer.announceWinner(winner);
    }

    public void driveRound() {
        for (Driveable aRacer : theRacers) {
            if (aRacer.isBrokenDown()) {
                this.scheduleForRepairs(aRacer);
                continue;
            }

            try {
                this.raceAnnouncer.announceRacerBeginRound(aRacer);
                BigDecimal milesTraveled = aRacer.drive();
                this.raceAnnouncer.announceRacerProgress(aRacer, milesTraveled);
            } catch (VehicleException explosion) {
                aRacer.breakDown();
                this.raceAnnouncer.announceBreakdown(explosion, aRacer);

            }
        }

        this.raceAnnouncer.announceRoundEnd(round);
        this.reportRoundPlacings();
    }

    /*
        _  _  ____  __    ____  ____  ____  ____ 
       / )( \(  __)(  )  (  _ \(  __)(  _ \/ ___)
       ) __ ( ) _) / (_/\ ) __/ ) _)  )   /\___ \
       \_)(_/(____)\____/(__)  (____)(__\_)(____/    
    
     */
    private void sortRacers() {
        Arrays.sort(theRacers);
    }

    public int updateRound() {
        return this.round++;
    }

    public boolean hasCrossedTheFinishLine(Driveable aRacer) {
        return aRacer.readOdometer().compareTo(this.trackLength) >= 0;
    }

    public void scheduleForRepairs(Driveable x) {
        if (this.raceMechanic == null) {
            this.raceAnnouncer.announceNoMechanic(x);
        } else{
            this.raceMechanic.tryToFix(x);
        }
    }

    public boolean canSomeoneStillDrive() {
        for (Driveable aRacer : theRacers) {
            if (!aRacer.isBrokenDown()) {
                return true;
            }
        }

        return false;
    }

    public boolean hasAWinner() {
        for (Driveable aRacer : theRacers) {
            if (this.hasCrossedTheFinishLine(aRacer)) {
                return true;
            }
        }
        return false;
    }

    public void reportRoundPlacings() {
        int place = 1;
        this.sortRacers();
        for (Driveable aRacer : theRacers) {
            this.raceAnnouncer.announceDriverPlacement(place, aRacer);
            place++;
        }
    }

    public void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Oops. The race is over.");
            throw new RuntimeException("It broke.");
        }
    }

}

package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class FieldDay {

    public static void main(String[] args) {
        //Scanner and Variable Declare/Init
        Scanner userInput = new Scanner(System.in);
        String userName;
        String userTeam;

        //Get Name Prompt
        System.out.print("What's your last name? ");
        userName = userInput.next();

        //Use name to determine team
        userTeam = teamCaptain(userName);

        //Print Team
        System.out.println("Aha! You’re on the team " + userTeam + "!");
        System.out.println("Good luck in the games!");
    }

    public static String teamCaptain(String userName) {
        if (userName.compareTo("Baggins") < 0) {
            return "Red Dragons";
        } else if (userName.compareTo("Baggins") > 0 && userName.compareTo("Dresden") < 0) {
            return "Dark Wizards";
        } else if (userName.compareTo("Dresden") > 0 && userName.compareTo("Howl") < 0) {
            return "Moving Castles";
        } else if (userName.compareTo("Howl") > 0 && userName.compareTo("Potter") < 0) {
            return "Golden Snitches";
        } else if (userName.compareTo("Potter") > 0 && userName.compareTo("Vimes") < 0) {
            return "Night Guards";
        } else {
            return "Black Holes";
        }
    }
}

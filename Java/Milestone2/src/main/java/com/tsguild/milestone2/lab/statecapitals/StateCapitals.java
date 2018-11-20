package com.tsguild.milestone2.lab.statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souldj673
 */
public class StateCapitals {

    //Create Class Accessible Map for States / Capitals
    public static Map<String, String> stateCapitalPairs = new HashMap<>();

    public static void main(String[] args) {
        //Calls Map Building Method
        mapBuild();

        //Put Map values into collections for proper printouts
        Collection<String> states = stateCapitalPairs.keySet();
        Collection<String> capitals = stateCapitalPairs.values();

        //Print States to Console
        System.out.println("STATES");
        infoPrinter(states);

        System.out.println("");

        //Print Capitals to Console
        System.out.println("CAPITALS");
        infoPrinter(capitals);

        System.out.println("");

        //Print State/Capital Pair
        System.out.println("STATES / CAPITALS");
        infoPrinter(states, stateCapitalPairs);

    }

    private static void mapBuild() {
        //Add All States and Capitals to Map
        stateCapitalPairs.put("Alabama", "Montgomery");
        stateCapitalPairs.put("Alaska", "Juneau");
        stateCapitalPairs.put("Arizona", "Phoenix");
        stateCapitalPairs.put("Arkansas", "Little Rock");
        stateCapitalPairs.put("California", "Sacramento");
        stateCapitalPairs.put("Colorado", "Denver");
        stateCapitalPairs.put("Connecticut", "Hartford");
        stateCapitalPairs.put("Delaware", "Dover");
        stateCapitalPairs.put("Florida", "Tallahassee");
        stateCapitalPairs.put("Georgia", "Atlanta");
        stateCapitalPairs.put("Hawaii", "Honolulu");
        stateCapitalPairs.put("Idaho", "Boise");
        stateCapitalPairs.put("Illinois", "Springfield");
        stateCapitalPairs.put("Indiana", "Indianapolis");
        stateCapitalPairs.put("Iowa", "Des Moines");
        stateCapitalPairs.put("Kansas", "Topeka");
        stateCapitalPairs.put("Kentucky", "Frankfort");
        stateCapitalPairs.put("Louisiana", "Baton Rouge");
        stateCapitalPairs.put("Maine", "Augusta");
        stateCapitalPairs.put("Maryland", "Annapolis");
        stateCapitalPairs.put("Massachusetts", "Boston");
        stateCapitalPairs.put("Michigan", "Lansing");
        stateCapitalPairs.put("Minnesota", "St. Paul");
        stateCapitalPairs.put("Mississippi", "Jackson");
        stateCapitalPairs.put("Missouri", "Jefferson City");
        stateCapitalPairs.put("Montana", "Helena");
        stateCapitalPairs.put("Nebraska", "Lincoln");
        stateCapitalPairs.put("Nevada", "Carson City");
        stateCapitalPairs.put("New Hampshire", "Concord");
        stateCapitalPairs.put("New Jersey", "Trenton");
        stateCapitalPairs.put("New Mexico", "Santa Fe");
        stateCapitalPairs.put("New York", "Albany");
        stateCapitalPairs.put("North Carolina", "Raleigh");
        stateCapitalPairs.put("North Dakota", "Bismarck");
        stateCapitalPairs.put("Ohio", "Columbus");
        stateCapitalPairs.put("Oklahoma", "Oklahoma City");
        stateCapitalPairs.put("Oregon", "Salem");
        stateCapitalPairs.put("Pennsylvania", "Harrisburg");
        stateCapitalPairs.put("Rhode Island", "Providence");
        stateCapitalPairs.put("South Carolina", "Columbia");
        stateCapitalPairs.put("South Dakota", "Pierre");
        stateCapitalPairs.put("Tennessee", "Nashville");
        stateCapitalPairs.put("Texas", "Austin");
        stateCapitalPairs.put("Utah", "Salt Lake City");
        stateCapitalPairs.put("Vermont", "Montpelier");
        stateCapitalPairs.put("Virginia", "Richmond");
        stateCapitalPairs.put("Washington", "Olympia");
        stateCapitalPairs.put("West Virginia", "Charleston");
        stateCapitalPairs.put("Wisconsin", "Madison");
        stateCapitalPairs.put("Wyoming", "Cheyenne");
    }

    public static void infoPrinter(Collection<String> collection) {
        for (String positionValue : collection) {
            System.out.println(positionValue);
        }
    }

    public static void infoPrinter(Collection<String> collection, Map<String, String> map) {

        for (String positionValue : collection) {
            System.out.println(positionValue + " - " + map.get(positionValue));
        }
    }
}

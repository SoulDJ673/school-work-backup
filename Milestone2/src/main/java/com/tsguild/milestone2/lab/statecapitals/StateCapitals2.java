package com.tsguild.milestone2.lab.statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author souldj673
 */
public class StateCapitals2 {

    //Create Class Accessible Map for States / Capitals
    public static Map<String, Capital> stateCapitalPairs = new HashMap<>();

    public static void main(String[] args) {
        //Separate States and Capitals
        Collection<String> states = stateCapitalPairs.keySet();
        Collection<Capital> capitals = stateCapitalPairs.values();
        
        //Iterate through Collections and print info
        for (String state : states) {
            
        }
    }

    private static void mapBuilder() {

        //Constructs and puts Captial objects into map with their State as the key
        stateCapitalPairs.put("Alabama", new Capital("Montgomery", 200022, 156));
        stateCapitalPairs.put("Alaska", new Capital("Juneau", 32468, 3255));
        stateCapitalPairs.put("Arizona", new Capital("Phoenix", 4737270, 517));
        stateCapitalPairs.put("Arkansas", new Capital("Little Rock", 198541, 121));
        stateCapitalPairs.put("California", new Capital("Sacramento", 495234, 100));
        stateCapitalPairs.put("Colorado", new Capital("Denver", 693060, 155));
        stateCapitalPairs.put("Connecticut", new Capital("Hartford", 123243, 18));
        stateCapitalPairs.put("Delaware", new Capital("Dover", 200022, 156));
        stateCapitalPairs.put("Florida", new Capital("Tallahassee", 190894, 103));
        stateCapitalPairs.put("Georgia", new Capital("Atlanta", 472522, 134));
        stateCapitalPairs.put("Hawaii", new Capital("Honolulu", 352769, 68));
        stateCapitalPairs.put("Idaho", new Capital("Boise", 223154, 83));
        stateCapitalPairs.put("Illinois", new Capital("Springfield", 115715, 66));
        stateCapitalPairs.put("Indiana", new Capital("Indianapolis", 864771, 368));
        stateCapitalPairs.put("Iowa", new Capital("Des Moines", 215472, 83));
        stateCapitalPairs.put("Kansas", new Capital("Topeka", 126808, 61));
        stateCapitalPairs.put("Kentucky", new Capital("Frankfort", 27885, 15));
        stateCapitalPairs.put("Louisiana", new Capital("Baton Rouge", 215472, 83));

        //Getting Lazy, Generate Random Pop/Area Values
        Random facts = new Random();
        stateCapitalPairs.put("Maine", new Capital("Augusta", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Maryland", new Capital("Annapolis", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Massachusetts", new Capital("Boston", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Michigan", new Capital("Lansing", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Minnesota", new Capital("St. Paul", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Mississippi", new Capital("Jackson", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Missouri", new Capital("Jefferson City", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Montana", new Capital("Helena", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Nebraska", new Capital("Lincoln", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Nevada", new Capital("Carson City", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("New Hampshire", new Capital("Concord", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("New Jersey", new Capital("Trenton", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("New Mexico", new Capital("Santa Fe", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("New York", new Capital("Albany", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("North Carolina", new Capital("Raleigh", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("North Dakota", new Capital("Bismarck", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Ohio", new Capital("Columbus", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Oklahoma", new Capital("Oklahoma City", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Pennsylvania", new Capital("Harrisburg", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Rhode Island", new Capital("Providence", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("South Carolina", new Capital("Columbia", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("South Dakota", new Capital("Pierre", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Tennessee", new Capital("Nashville", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Texas", new Capital("Austin", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Utah", new Capital("Salt Lake City", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Vermont", new Capital("Montpelier", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Virginia", new Capital("Richmond", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Washington", new Capital("Olympia", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("West Virginia", new Capital("Charleston", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Wisconsin", new Capital("Madison", facts.nextInt(500000), facts.nextInt(500)));
        stateCapitalPairs.put("Wyoming", new Capital("Cheyenne", facts.nextInt(500000), facts.nextInt(500)));

    }
}

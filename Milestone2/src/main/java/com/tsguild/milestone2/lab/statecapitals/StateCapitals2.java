package com.tsguild.milestone2.lab.statecapitals;

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
        stateCapitalPairs.put("Louisiana", new Capital("Baton Rouge", 215472, 83));
        stateCapitalPairs.put("Louisiana", new Capital("Baton Rouge", 215472, 83));
        stateCapitalPairs.put("Louisiana", new Capital("Baton Rouge", 215472, 83));
        stateCapitalPairs.put("Louisiana", new Capital("Baton Rouge", 215472, 83));
    }
}

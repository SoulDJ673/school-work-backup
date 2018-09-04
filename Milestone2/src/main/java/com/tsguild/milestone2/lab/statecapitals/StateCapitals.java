package com.tsguild.milestone2.lab.statecapitals;

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
        
        //Print States to Console
        System.out.println("STATES");
        System.out.println(stateCapitalPairs.keySet());
        
        //Print Capitals to Console
        System.out.println("CAPITALS");
        System.out.println(stateCapitalPairs.values());

    }

    private static void mapBuild() {
        //Add All States and Capitals to Map
        stateCapitalPairs.put("\n\nAlabama", "\nMontgomery");
        stateCapitalPairs.put("\n\nAlaska", "\nJuneau");
        stateCapitalPairs.put("\nArizona", "\nPhoenix");
        stateCapitalPairs.put("\nArkansas", "\nLittle Rock");
        stateCapitalPairs.put("\nCalifornia", "\nSacramento");
        stateCapitalPairs.put("\nColorado", "\nDenver");
        stateCapitalPairs.put("\nConnecticut", "\nHartford");
        stateCapitalPairs.put("\nDelaware", "\nDover");
        stateCapitalPairs.put("\nFlorida", "\nTallahassee");
        stateCapitalPairs.put("\nGeorgia", "\nAtlanta");
        stateCapitalPairs.put("\nHawaii", "\nHonolulu");
        stateCapitalPairs.put("\nIdaho", "\nBoise");
        stateCapitalPairs.put("\nIllinois", "\nSpringfield");
        stateCapitalPairs.put("\nIndiana", "\nIndianapolis");
        stateCapitalPairs.put("\nIowa", "\nDes Moines");
        stateCapitalPairs.put("\nKansas", "\nTopeka");
        stateCapitalPairs.put("\nKentucky", "\nFrankfort");
        stateCapitalPairs.put("\nLouisiana", "\nBaton Rouge");
        stateCapitalPairs.put("\nMaine", "\nAugusta");
        stateCapitalPairs.put("\nMaryland", "\nAnnapolis");
        stateCapitalPairs.put("\nMassachusetts", "\nBoston");
        stateCapitalPairs.put("\nMichigan", "\nLansing");
        stateCapitalPairs.put("\nMinnesota", "\nSt. Paul");
        stateCapitalPairs.put("\nMississippi", "\nJackson");
        stateCapitalPairs.put("\nMissouri", "\nJefferson City");
        stateCapitalPairs.put("\nMontana", "\nHelena");
        stateCapitalPairs.put("\nNebraska", "\nLincoln");
        stateCapitalPairs.put("\nNevada", "\nCarson City");
        stateCapitalPairs.put("\nNew Hampshire", "\nConcord");
        stateCapitalPairs.put("\nNew Jersey", "\nTrenton");
        stateCapitalPairs.put("\nNew Mexico", "\nSanta Fe");
        stateCapitalPairs.put("\nNew York", "\nAlbany");
        stateCapitalPairs.put("\nNorth Carolina", "\nRaleigh");
        stateCapitalPairs.put("\nNorth Dakota", "\nBismarck");
        stateCapitalPairs.put("\nOhio", "\nColumbus");
        stateCapitalPairs.put("\nOklahoma", "\nOklahoma City");
        stateCapitalPairs.put("\nOregon", "\nSalem");
        stateCapitalPairs.put("\nPennsylvania", "\nHarrisburg");
        stateCapitalPairs.put("\nRhode Island", "\nProvidence");
        stateCapitalPairs.put("\nSouth Carolina", "\nColumbia");
        stateCapitalPairs.put("\nSouth Dakota", "\nPierre");
        stateCapitalPairs.put("\nTennessee", "\nNashville");
        stateCapitalPairs.put("\nTexas", "\nAustin");
        stateCapitalPairs.put("\nUtah", "\nSalt Lake City");
        stateCapitalPairs.put("\nVermont", "\nMontpelier");
        stateCapitalPairs.put("\nVirginia", "\nRichmond");
        stateCapitalPairs.put("\nWashington", "\nOlympia");
        stateCapitalPairs.put("\nWest Virginia", "\nCharleston");
        stateCapitalPairs.put("\nWisconsin", "\nMadison");
        stateCapitalPairs.put("\nWyoming", "\nCheyenne");
    }
}

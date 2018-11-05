/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ahill
 * @author souldj673
 */
public class WorkWithArrays {

    /* 
    ** Given an array of ints, find and return the maximum value.
    **
    ** Ex:
    ** maxOfArray( {1}  ) ->  1
    ** maxOfArray( {3,4,5}  ) ->  5
    ** maxOfArray( {-9000, -700, -50, -3}  ) ->  -3
     */
    public static int maxOfArray(int[] numbers) {
        int biggestNum = numbers[0];

        for (int num : numbers) {
            if (num > biggestNum) {
                biggestNum = num;
            }
        }

        return biggestNum;
    }

    /* 
    ** Given a integer and an array of ints, times each number in the array by the multiplier.
    **
    ** Ex:
    ** multiplyAll( 5 , [ 1 , 2 , 3 , 4 , 5 ] ) ->  [ 5 , 10 , 15 , 20 , 25 ]
    ** multiplyAll( 0 , [ 1 , 1 , 1 , 1 , 1  , 1 , 1 , 1 , 1 ] ) ->  [ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ]
    ** multiplyAll( -1 , [ -2 , 0 , 0 , 1 ] ) ->  [ 2 , 0 , 0 , -1 ]
     */
    public static int[] multiplyAll(int multiplier, int[] numbers) {

        int i = 0;

        for (int num : numbers) {
            num = num * multiplier;
            numbers[i] = num;
            i++;
        }

        return numbers;
    }

    /* 
    ** Given an array of words turn it into a single camelCased phrase. 
    ** Lower case the first word, capitalize the first letter (but only the first) of the rest.
    **
    ** Ex:
    ** camelCaseIt( {"llama", "llama", "duck"}  ) ->  "llamaLlamaDuck"
    ** camelCaseIt( {"lambs", "eat", "oats", "and", "does", "eat", "oats"}  ) ->  "lambsEatOatsAndDoesEatOats"
    ** camelCaseIt( {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"}  ) ->  "doOrDoNotThereIsNoTry"
     */
    public static String camelCaseIt(String[] words) {

        String first = words[0];

        String[] camelCased = new String[words.length];
        int i = 0;

        for (String word : words) {
            if (i == 0) {
                camelCased[0] = word.toLowerCase();
                i++;
            } else {
                word = word.toUpperCase();
                String exceptFirst = word.substring(1);
                exceptFirst = exceptFirst.toLowerCase();
                word = word.replace(exceptFirst.toUpperCase(), exceptFirst);
                camelCased[i] = word;
                i++;

            }
        }

        String stringified = "";
        for (String camelWord : camelCased) {
            stringified += camelWord;
        }

        return stringified;
    }

    /* 
    ** Given an array of colors, return the one that occurs the most often. 
    ** If there are multiples that share 'most common', return the one that came first in the list.
    **
    ** Ex:
    ** mostCommonColor( {"Red", "Blue", "Red", "Blue", "Red", "Blue", "Red"}  ) ->  "Red"
    ** mostCommonColor( {"Violet", "Indigo", "Blue", "Green", "Yellow", "Orange", "Red"}  ) ->  "Violet"
    ** mostCommonColor( {"Green", "Green", "Green", "Green", "Green", "Red", "Green"}  ) ->  "Green"
     */
    public static String mostCommonColor(String[] colors) {
        Map<String, Integer> colorKeeper = new HashMap<>();

        for (String color : colors) {
            if (colorKeeper.containsKey(color)) {
                colorKeeper.replace(color, (colorKeeper.get(color) + 1));
            } else {
                colorKeeper.put(color, 1);
            }
        }
        
        Collection<Integer> occurances = colorKeeper.values();
        
        int mode = 0;
        
        for (int occurance : occurances) {
            
        }
    }

    /* 
    ** Given an array of doubles, return the biggest number of the lot ... as if the decimal had gone missing!
    **
    ** Ex:
    ** pointFree( [1.1, .22]  ) ->  11
    ** pointFree( [ .039 , 20 , .005005 ]  ) ->  5005
    ** pointFree( [ -9.9 , -700 , -.5  ]  ) ->  -5
     */
    public static int pointFree(double[] numbers) {
        throw new UnsupportedOperationException("Code not yet written...!");
    }

}

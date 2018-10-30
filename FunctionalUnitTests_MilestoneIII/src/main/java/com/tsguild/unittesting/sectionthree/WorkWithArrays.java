/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

/**
 *
 * @author ahill
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
    public int maxOfArray(int[] numbers){
        throw new UnsupportedOperationException("Code not yet written...!");
    }
    
    /* 
    ** Given a integer and an array of ints, times each number in the array by the multiplier.
    **
    ** Ex:
    ** multiplyAll( 5 , [ 1 , 2 , 3 , 4 , 5 ] ) ->  [ 5 , 10 , 15 , 20 , 25 ]
    ** multiplyAll( 0 , [ 1 , 1 , 1 , 1 , 1  , 1 , 1 , 1 , 1 ] ) ->  [ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ]
    ** multiplyAll( -1 , [ -2 , 0 , 0 , 1 ] ) ->  [ 2 , 0 , 0 , -1 ]
    */
    public static int[] multiplyAll(int multiplier, int[] numbers){
        throw new UnsupportedOperationException("Code not yet written...!");
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
    public String camelCaseIt(String[] words){
        throw new UnsupportedOperationException("Code not yet written...!");
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
    public String mostCommonColor(String[] colors){
        throw new UnsupportedOperationException("Code not yet written...!");
    }
    
    /* 
    ** Given an array of doubles, return the biggest number of the lot ... as if the decimal had gone missing!
    **
    ** Ex:
    ** pointFree( [1.1, .22]  ) ->  11
    ** pointFree( [ .039 , 20 , .005005 ]  ) ->  5005
    ** pointFree( [ -9.9 , -700 , -.5  ]  ) ->  -5
    */
    public int pointFree(double[] numbers){
        throw new UnsupportedOperationException("Code not yet written...!");
    }
    
    
}

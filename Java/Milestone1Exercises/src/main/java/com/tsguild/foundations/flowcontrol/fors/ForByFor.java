package com.tsguild.foundations.flowcontrol.fors;

/**
 *
 * @author souldj673
 */
public class ForByFor {

    public static void main(String[] args) {

        RowDeclaration: //Rows
        for (int i = 0; i < 3; i++) {
            System.out.print("|");

            RowCompletionist:  //Columns
            for (int j = 0; j < 3; j++) {

                if (j == 1 && i == 1) {  //###
                    SpotFillerHash:
                    for (int k = 0; k < 3; k++) {
                        System.out.print("#");
                    }
                } else if (i == 1) {  //@@@
                    SpotFillerAt:
                    for (int k = 0; k < 3; k++) {
                        System.out.print("@");
                    }
                } else if (j == 1) {  //$$$
                    SpotFiller$:
                    for (int k = 0; k < 3; k++) {
                        System.out.print("$");
                    }
                } else {  //***
                    SpotFillerStar:
                    for (int k = 0; k < 3; k++) {
                        System.out.print("*");
                    }
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}

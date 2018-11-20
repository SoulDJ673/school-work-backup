package com.tsguild.addressbook.ui;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class UserIOConsoleImpl implements UserIO {

    //Class accessible scanner for user input
    private Scanner userInput = new Scanner(System.in);

    //Method Implementations
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String msgPrompt) {
        //Declare Var for holding user input (string)
        String userS;

        System.out.println(msgPrompt);
        userS = userInput.nextLine(); //Change to nextLine to allow empty input (Press enter to continue)

        //Return user input back to caller
        return userS;
    }

    @Override
    public int readInt(String msgPrompt) {
        //Declare Var for holding user input (integer)
        String userIS;
        int userI;

        System.out.println(msgPrompt);

        //Validate Input (Infinite loop is intentional)
        while (true) {

            userIS = userInput.nextLine();
            try {
                userI = Integer.parseInt(userIS);
                break;
            } catch (Exception e) {
                System.out.println("You must input an integer.");
            }
        }
        return userI;
    }

    @Override
    public int readInt(String msgPrompt, int min, int max) {
        //Declare Var for holding user input (integer)
        String userIS;
        int userI;

        System.out.println(msgPrompt);

        //Validate Input (Infinite loop is intentional)
        validate:
        while (true) {
            userIS = userInput.nextLine();
            try {
                userI = Integer.parseInt(userIS);

                //Repeat if user gives an integer that is out of bounds
                if (userI <= max && userI >= min) {
                    return userI;
                } else {
                    System.out.println("You must input a value between " + min + " and " + max);
                }

            } catch (Exception e) {
                System.out.println("You must input an integer.");
            }
        }
    }

    @Override
    public double readDouble(String msgPrompt) {
        //Declare Var for holding user input (double)
        String userDS;
        double userD;

        System.out.println(msgPrompt);

        //Validate Input (Infinite loop is intentional)
        while (true) {
            userDS = userInput.nextLine();
            try {
                userD = Double.parseDouble(userDS);
                break;
            } catch (Exception e) {
                System.out.println("You must input a double.");
            }
        }
        return userD;
    }

    @Override
    public double readDouble(String msgPrompt, double min, double max) {
        //Declare Var for holding user input (double)
        String userDS;
        double userD;

        System.out.println(msgPrompt);

        //Validate Input (Infinite loop is intentional)
        validate:
        while (true) {
            userDS = userInput.nextLine();
            try {
                userD = Double.parseDouble(userDS);

                //Repeat if user gives a double that is out of bounds
                if (userD <= max && userD >= min) {
                    return userD;
                } else {
                    System.out.println("You must input a value between " + min + " and " + max);
                }

            } catch (Exception e) {
                System.out.println("You must input a double.");
            }
        }
    }

    @Override
    public float readFloat(String msgPrompt) {
        //Declare Var for holding user input (float)
        String userFS;
        float userF;

        System.out.println(msgPrompt);

        //Validate Input (Infinite loop is intentional)
        while (true) {
            userFS = userInput.nextLine();
            try {
                userF = Float.parseFloat(userFS);
                break;
            } catch (Exception e) {
                System.out.println("You must input a float.");
            }
        }
        return userF;
    }

    @Override
    public float readFloat(String msgPrompt, float min, float max) {
        //Declare Var for holding user input (float)
        String userFS;
        float userF;

        System.out.println(msgPrompt);

        //Validate Input (Infinite loop is intentional)
        validate:
        while (true) {
            userFS = userInput.nextLine();
            try {
                userF = Float.parseFloat(userFS);

                //Repeat if user gives a float that is out of bounds
                if (userF <= max && userF >= min) {
                    return userF;
                } else {
                    System.out.println("You must input a value between " + min + " and " + max);
                }

            } catch (Exception e) {
                System.out.println("You must input a float.");
            }
        }
    }

    @Override
    public long readLong(String msgPrompt) {
        //Declare Var for holding user input (long)
        String userLS;
        long userL;

        System.out.println(msgPrompt);

        //Validate Input (Infinite loop is intentional)
        while (true) {
            userLS = userInput.nextLine();
            try {
                userL = Long.parseLong(userLS);
                break;
            } catch (Exception e) {
                System.out.println("You must input a long.");
            }
        }
        return userL;
    }

    @Override
    public long readLong(String msgPrompt, long min, long max) {
        //Declare Var for holding user input (long)
        String userLS;
        long userL;

        System.out.println(msgPrompt);

        //Validate Input (Infinite loop is intentional)
        validate:
        while (true) {
            userLS = userInput.nextLine();
            try {
                userL = Long.parseLong(userLS);

                //Repeat if user gives an long that is out of bounds
                if (userL <= max && userL >= min) {
                    return userL;
                } else {
                    System.out.println("You must input a value between " + min + " and " + max);
                }

            } catch (Exception e) {
                System.out.println("You must input a long.");
            }
        }
    }
}

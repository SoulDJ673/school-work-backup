package com.tsguild.milestone2.challenge.goblinrpg.weapons;

import com.tsguild.milestone2.challenge.goblinrpg.Weapon;

/**
 *
 * @author souldj673
 */
public class Stick implements Weapon {

    @Override
    public int strike() {
        return 2; 
    }

    @Override
    public String getName() {
        return "Stick";
    }

    @Override
    public String getDescription() {
        return "A pointy stick.";
    }

    @Override
    public int getValue() {
        return 0; 
    }

}

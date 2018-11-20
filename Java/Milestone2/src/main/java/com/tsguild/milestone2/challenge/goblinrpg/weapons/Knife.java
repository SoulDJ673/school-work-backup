/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone2.challenge.goblinrpg.weapons;

import com.tsguild.milestone2.challenge.goblinrpg.Weapon;

/**
 *
 * @author souldj673
 */
public class Knife implements Weapon {

    @Override
    public int strike() {
        return 7;
    }

    @Override
    public String getName() {
        return "Knife";
    }

    @Override
    public String getDescription() {
        return "A rusty knife you found in the dungeon.  Nothing too special.";
    }

    @Override
    public int getValue() {
        return 5;
    }
    
}

package com.tsguild.milestone2.challenge.goblinrpg.armor;

import com.tsguild.milestone2.challenge.goblinrpg.Armor;

/**
 *
 * @author souldj673
 */
public class Orphan implements Armor {

    @Override
    public int protect(int damage) {
        return damage + 4;
    }

    @Override
    public String getName() {
        return "Orphaned";
    }

    @Override
    public String getDescription() {
        return "Opposite of Mom's Love, you remember that you have no parents.  This saddens you, causing you take damage";
    }

    @Override
    public int getValue() {
        return 6969;
    }
    
}

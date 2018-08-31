package com.tsguild.milestone2.challenge.goblinrpg.armor;

import com.tsguild.milestone2.challenge.goblinrpg.Armor;

/**
 *
 * @author souldj673
 */
public class PaperBag implements Armor {

    @Override
    public int protect(int damage) {
        return damage;
    }

    @Override
    public String getName() {
        return "Paper Bag";
    }

    @Override
    public String getDescription() {
        return "A bag. Made from paper. Really?";
    }

    @Override
    public int getValue() {
        return 0;
    }

}

package com.tsguild.milestone2.challenge.goblinrpg.armor;

import com.tsguild.milestone2.challenge.goblinrpg.Armor;

/**
 *
 * @author souldj673
 */
public class MomLove implements Armor {

    @Override
    public int protect(int damage) {
        return damage - 2;
    }

    @Override
    public String getName() {
        return "Your mom's love";
    }

    @Override
    public String getDescription() {
        return "You remember that your mum loves you, giving you a bit of strength to continue :)";
    }

    @Override
    public int getValue() {
        return 69;
    }

}

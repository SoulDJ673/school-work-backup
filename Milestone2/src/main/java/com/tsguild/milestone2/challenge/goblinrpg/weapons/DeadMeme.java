package com.tsguild.milestone2.challenge.goblinrpg.weapons;

import com.tsguild.milestone2.challenge.goblinrpg.Weapon;

/**
 *
 * @author souldj673
 */
public class DeadMeme implements Weapon {

    @Override
    public int strike() {
        return 20;
    }

    @Override
    public String getName() {
        return "Dead Meme";
    }

    @Override
    public String getDescription() {
        return "A cruel weapon of mass destruction, banned in most countries.  Using this will overwhelm your opponent with a lethal dose of cringe.";
    }

    @Override
    public int getValue() {
        return 0;
    }

}

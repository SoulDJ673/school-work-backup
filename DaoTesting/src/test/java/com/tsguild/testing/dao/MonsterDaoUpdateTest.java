/*
 * Copyright (C) 2018 souldj673
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tsguild.testing.dao;

import com.tsguild.testing.dao.implementations.*;
import com.tsguild.testing.model.Monster;
import static com.tsguild.testing.model.MonsterType.LIZARDMAN;
import static com.tsguild.testing.model.MonsterType.VAMPIRE;
import static com.tsguild.testing.model.MonsterType.WEREWOLF;
import static com.tsguild.testing.model.MonsterType.YETI;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class MonsterDaoUpdateTest {

    MonsterDao testDao;
    Monster jeff;
    Monster ethan;
    Monster owo;

    public MonsterDaoUpdateTest() {
    }

    @Before
    public void setUp() {
        testDao = new BadMonsterDaoA();

        //Creating Monsters...
        jeff = new Monster("Jeff", LIZARDMAN, 7, "iced creams");
        ethan = new Monster("Ethan", VAMPIRE, 14, "SPF 100 Sunscreen");
        owo = new Monster("OwO", YETI, 69, ">_>");

        //Populating Map...
        testDao.addMonster(0, jeff);
        testDao.addMonster(1, ethan);
        testDao.addMonster(2, owo);
    }

    @Test
    public void updateOneTest() {
        //Create UpdatedJeff...
        Monster updatedJeff = new Monster("Jeff", LIZARDMAN, 12, "Lasagna");

        //Update Jeff...
        testDao.updateMonster(0, updatedJeff);
        Monster jeffMaybe = testDao.getMonster(0);

        //Assert...
        Assert.assertEquals("Checking to see if the new Jeff is updatedJeff",
                true, updatedJeff.toString().equals(jeffMaybe.toString()));
    }

    @Test
    public void updateManyTest() {
        //Create updatedMonsters...
        Monster updatedJeff = new Monster("Jeff", LIZARDMAN, 12, "Lasagna");
        Monster updatedEthan = new Monster("Ethan", VAMPIRE, 24, "Kool Aid");
        Monster updatedOwO = new Monster("OwO", YETI, 420, "<_<");

        //Update Monsters...
        testDao.updateMonster(0, updatedJeff);
        testDao.updateMonster(1, updatedEthan);
        testDao.updateMonster(2, updatedOwO);

        //Retrieve Monsters for Testing...
        List<Monster> monsters = testDao.getAllMonsters();

        //Assert...
        Assert.assertEquals("Making sure that old Jeff isn't in the monsters...",
                false, monsters.contains(jeff));
        Assert.assertEquals("Making sure that old Ethan isn't in the monsters...",
                false, monsters.contains(ethan));
        Assert.assertEquals("Making sure that old OwO isn't in the monsters...",
                false, monsters.contains(owo));

        Assert.assertEquals("Making sure that new Jeff is updatedJeff...", true,
                monsters.get(0).toString().equals(updatedJeff.toString()));
        Assert.assertEquals("Making sure that new Ethan is updatedEthan...", true,
                monsters.get(1).toString().equals(updatedEthan.toString()));
        Assert.assertEquals("Making sure that new OwO is updatedOwO...", true,
                monsters.get(2).toString().equals(updatedOwO.toString()));
    }

    @Test
    public void updateNonExistentTest() {
        //Create Monster
        Monster wolfo = new Monster("Wolfo", WEREWOLF, 420, "^w^");

        //Update...
        testDao.updateMonster(4, wolfo); //This shouldn't work because Wolfo was never in the map

        //Assert
        Assert.assertEquals("Making sure Wolfo isn't in Map...", false,
                testDao.getAllMonsters().contains(wolfo));
    }

    @Test
    public void badDaoATest() {
        //Create updatedJeff with peopleEaten as id
        Monster updatedJeff = new Monster("Jeff", LIZARDMAN, 0, "Lasagna");

        //Update...
        testDao.updateMonster(0, updatedJeff);

        //Assert
        Assert.assertEquals("Making sure only one Jeff in Map...", false,
                testDao.getAllMonsters().contains(jeff));

        //Updating Jeff Again, but he ate someone
        Monster updatedJeffAgain = new Monster("Jeff", LIZARDMAN, 1, "Lasagna");

        //Update...
        testDao.updateMonster(0, updatedJeffAgain); //Same ID...

        //Proof that the peopleEaten count is being used as Key
        for (Monster monster : testDao.getAllMonsters()) {
            System.out.println(monster.toString());
        }

        //Assert
        Assert.assertEquals("There should still be only one Jeff...", false,
                testDao.getAllMonsters().contains(updatedJeff));
        /**
         * updatedJeffAgain should've replaced updatedJeff! He was added next to
         * updatedJeff though because his peopleEaten count changed!
         */

    }
}

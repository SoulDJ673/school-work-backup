package com.tsguild.testing.dao;

import com.tsguild.testing.dao.implementations.*;
import com.tsguild.testing.model.Monster;
import static com.tsguild.testing.model.MonsterType.LIZARDMAN;
import static com.tsguild.testing.model.MonsterType.VAMPIRE;
import static com.tsguild.testing.model.MonsterType.YETI;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class MonsterDaoRemoveTest {

    MonsterDao testDao;

    public MonsterDaoRemoveTest() {
    }

    @Before
    public void setUp() {
        testDao = new AGoodMonsterDao();
    }

    @Test
    public void removeAndGetMonsterTest() {
        //Creating Monster...
        Monster jeff = new Monster("Jeff", LIZARDMAN, 7, "iced creams");

        //Adding to Map...
        testDao.addMonster(0, jeff);

        //Remove from Map...
        Monster removedMonster = testDao.removeMonster(0);
        List<Monster> monsters = testDao.getAllMonsters();

        //Asserting...
        Assert.assertEquals("Making sure that Jeff isn't here...", false,
                monsters.contains(jeff));
        Assert.assertEquals("Making sure that removed monster was Jeff...", true, jeff.toString().equals(removedMonster.toString()));
    }

    @Test
    public void removeMultiAndGetAllMonsterTest() {
        //Creating Monsters...
        Monster jeff = new Monster("Jeff", LIZARDMAN, 7, "iced creams");
        Monster ethan = new Monster("Ethan", VAMPIRE, 14, "SPF 100 Sunscreen");
        Monster owo = new Monster("OwO", YETI, 69, ">_>");

        //Adding to Map...
        testDao.addMonster(0, jeff);
        testDao.addMonster(1, ethan);
        testDao.addMonster(2, owo);

        List<Monster> monstersHere = testDao.getAllMonsters();

        //Removing from Map...
        Monster removedMonster1 = testDao.removeMonster(0);
        Monster removedMonster2 = testDao.removeMonster(1);
        Monster removedMonster3 = testDao.removeMonster(2);

        List<Monster> monstersGone = testDao.getAllMonsters();

        //Asserting...
        Assert.assertEquals("Making sure that the monster lists differ before/a"
                + "fter removal...", false, monstersGone.containsAll(monstersHere));

        Assert.assertEquals("Making sure Jeff was removed...", false,
                monstersGone.contains(jeff));
        Assert.assertEquals("Verifying Jeff's identity...", true,
                jeff.toString().equals(removedMonster1.toString()));

        Assert.assertEquals("Making sure Ethan was removed...", false,
                monstersGone.contains(ethan));
        Assert.assertEquals("Verifying Ethan's identity...", true,
                ethan.toString().equals(removedMonster2.toString()));

        Assert.assertEquals("Making sure OwO was removed...", false,
                monstersGone.contains(owo));
        Assert.assertEquals("Verifying OwO's identity...", true,
                owo.toString().equals(removedMonster3.toString()));
    }

    @Test
    public void removeInvalidMonsterTest() {
        //No monsters should be in here...
        Monster removedMonster = testDao.removeMonster(4);

        //Asserting...
        Assert.assertEquals("Removing the monster with an ID of 4... Doesn't ex"
                + "ist, should get a null...", null, removedMonster);
    }
}

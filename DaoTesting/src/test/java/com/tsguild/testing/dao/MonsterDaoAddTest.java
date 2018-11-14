package com.tsguild.testing.dao;

import com.tsguild.testing.dao.implementations.AGoodMonsterDao;
import com.tsguild.testing.model.Monster;
import static com.tsguild.testing.model.MonsterType.*;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class MonsterDaoAddTest {

    MonsterDao testDao;

    public MonsterDaoAddTest() {
    }

    @Before
    public void setUp() {
        testDao = new AGoodMonsterDao();
    }

    @Test
    public void addMonsterTest() {

        //Creating Monster...
        Monster jeff = new Monster("Jeff", LIZARDMAN, 7, "iced creams");

        //Adding to Map...
        testDao.addMonster(0, jeff);
        Monster addedMonster = testDao.getMonster(0);

        //Asserting...
        Assert.assertEquals("Making sure that the monster added and the monster"
                + " in the map are the same...", true,
                addedMonster.toString().equals(jeff.toString()));
        Assert.assertEquals("Checking name...", jeff.getName(), addedMonster.getName());
        Assert.assertEquals("Checking type...", jeff.getType(), addedMonster.getType());
        Assert.assertEquals("Checking people munch count...", jeff.getPeopleEaten(), addedMonster.getPeopleEaten());
        Assert.assertEquals("Checking favorite food...", jeff.getFavoriteFood(), addedMonster.getFavoriteFood());

    }

    @Test
    public void addMultiAndGetAllMonsterTest() {

        //Creating Monsters...
        Monster jeff = new Monster("Jeff", LIZARDMAN, 7, "iced creams");
        Monster ethan = new Monster("Ethan", VAMPIRE, 14, "SPF 100 Sunscreen");
        Monster owo = new Monster("OwO", YETI, 69, ">_>");

        //Adding to Map...
        testDao.addMonster(0, jeff);
        testDao.addMonster(1, ethan);
        testDao.addMonster(2, owo);

        //Retrieving Monsters...
        List<Monster> monsters = testDao.getAllMonsters();

        //Asserting...
        Assert.assertEquals("Checking Monster Count...", 3, monsters.size());
        Assert.assertEquals("Checking to make sure Jeff is here...", true,
                monsters.contains(jeff));
        Assert.assertEquals("Checking to make sure Ethan is here...", true,
                monsters.contains(ethan));
        Assert.assertEquals("Checking to make sure OwO is here...", true,
                monsters.contains(owo));
    }

    @Test
    public void addNullTest() {
        //Creating null Monster...
        Monster nullMonster = null;

        //Adding to Map...
        testDao.addMonster(0, nullMonster);
        Monster addedMonster = testDao.getMonster(0);

        //Asserting...
        Assert.assertEquals("Making sure addedMonster & nullMonster are the sam"
                + "e...", true, nullMonster == addedMonster);
        Assert.assertEquals("The added Monster should be null...", null,
                addedMonster);
    }
}

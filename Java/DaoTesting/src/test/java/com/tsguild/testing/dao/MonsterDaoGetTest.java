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
public class MonsterDaoGetTest {

    MonsterDao testDao;
    Monster jeff;
    Monster ethan;
    Monster owo;

    public MonsterDaoGetTest() {
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
    public void getOneTest() {
        //Get Jeff...
        Monster retrievedJeff = testDao.getMonster(0);

        //Asserting...
        Assert.assertEquals("Verifying Jeff...", true,
                jeff.toString().equals(retrievedJeff.toString()));
    }

    @Test
    public void getAllTest() {
        //Get All...
        List<Monster> monsters = testDao.getAllMonsters();

        //Make sure they're all in there...
        Assert.assertEquals("Making sure Jeff is here...", true,
                monsters.contains(jeff));
        Assert.assertEquals("Making sure Ethan is here...", true,
                monsters.contains(ethan));
        Assert.assertEquals("Making sure OwO is here...", true,
                monsters.contains(owo));

        //Validating Identities...
        Assert.assertEquals("Making sure Jeff is Jeff...", true,
                monsters.get(0).toString().equals(jeff.toString()));
        Assert.assertEquals("Making sure Ethan is Ethan...", true,
                monsters.get(1).toString().equals(ethan.toString()));
        Assert.assertEquals("Making sure OwO is OwO...", true,
                monsters.get(2).toString().equals(owo.toString()));
    }

    @Test
    public void getInvalidTest() {
        //Get Invalid monster...
        Monster nullMonster = testDao.getMonster(7);

        //Asserting...
        Assert.assertEquals("Making sure the invalid id returns null...", null,
                nullMonster);
    }

    @Test
    public void getAllEmptyTest() {
        //Need an unpopulated Map...
        MonsterDao testDaoWithEmptyMap = new AGoodMonsterDao();

        //Get All from the empty Map
        List<Monster> emptyList = testDaoWithEmptyMap.getAllMonsters();

        //Asserting...
        Assert.assertEquals("Should return an empty list...", true,
                emptyList.isEmpty());
    }
}

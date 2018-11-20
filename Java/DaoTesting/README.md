# Monsterous Bad DAO Problems

This document is here to keep track of the various issues within each of the bad daos.

This is due Friday, November 16, 2018.

## BadMonsterDaoA

#### updateMonster(int id, Monster m)

	monsters.put(m.getPeopleEaten(), m);

The issue here is that .put should be .replace.  Because of the use of .put, even if the monster isn't currently in the Monster Map, it'll be added anyway.  This shouldn't be the case because that's what addMonster is for.  This also results in multiple versions of monsters being in the Map because the key that is being used here is the monster's PeopleEaten int rather than their ID.  This is shown with all of my **MonsterDaoUpdateTest** tests, but in more detail with the badDaoATest.


## BadMonsterDaoB
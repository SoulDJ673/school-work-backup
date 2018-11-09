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
package com.tsguild.milestone4;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author souldj673
 */
public class CamelTest {

    Camel testCamel;

    @Before
    public void setUp() {
        testCamel = new Camel("Sue", 7, 4);
    }

    @Test
    public void testCamelSpit() {
        String camelSpit = testCamel.spit();
        assertEquals("Checking camel spit...", "SPLOITUH!", camelSpit);
    }

    @Test
    public void testCamelMultiSpit() {
        testCamel.setAmountOfSpit(10);

        for (int i = 10; i > 0; i--) {
            assertEquals("Checking amount of camel spit before...", i, testCamel.getAmountOfSpit());

            String camelSpit = testCamel.spit();

            assertEquals("Checking camel spit...", "SPLOITUH!", camelSpit);
            assertEquals("Checking amount of camel spit after...", i - 1, testCamel.getAmountOfSpit());
        }

        String camelSpit = testCamel.spit();
        assertEquals("Checking camel spit...", "Thhhhhh...", camelSpit);

    }

    @Test
    public void testMadCamel() {
        //Make it mad
        testCamel.poke();

        int amountBeforeSpitting = testCamel.getAmountOfSpit();
        String camelSpit = testCamel.spit();

        //Asserting
        assertEquals("Checking camel spit...", "SPLOITUH! SPLOITUH! SPLOITUH! "
                + "SPLOITUH! SPLOITUH!", camelSpit);
        assertEquals("Checking spit loss...", amountBeforeSpitting - 5,
                testCamel.getAmountOfSpit());
    }

}

/*
 * Copyright 2008 original author or authors
 * 
 * This file is part of number-as-words.
 * 
 * number-as-words is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * number-as-words is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with number-as-words.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.ungoverned.jafl.words;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.ungoverned.jafl.words.impl.Speller_en;

/**
 * @author Peter De Bruycker
 */
public class Speller_enTest {
    @Test
    public void test() {
        Speller_en speller = new Speller_en();

        assertEquals("zero", speller.spell(0, 0));
        assertEquals("one", speller.spell(1, 0));
        assertEquals("sixteen", speller.spell(16, 0));
        assertEquals("one hundred", speller.spell(100, 0));
        assertEquals("one hundred eighteen", speller.spell(118, 0));
        assertEquals("two hundred", speller.spell(200, 0));
        assertEquals("two hundred nineteen", speller.spell(219, 0));
        assertEquals("eight hundred", speller.spell(800, 0));
        assertEquals("eight hundred one", speller.spell(801, 0));
        assertEquals("one thousand three hundred sixteen", speller.spell(1316, 0));
        assertEquals("one million", speller.spell(1000000, 0));
        assertEquals("two million", speller.spell(2000000, 0));
        assertEquals("three million two hundred", speller.spell(3000200, 0));
        assertEquals("seven hundred thousand", speller.spell(700000, 0));
        assertEquals("nine million", speller.spell(9000000, 0));
        assertEquals("one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine",
                speller.spell(123456789, 0));
        assertEquals("minus fourty five", speller.spell(-45, 0));
    }
}

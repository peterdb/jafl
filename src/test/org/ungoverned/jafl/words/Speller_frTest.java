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
import org.ungoverned.jafl.words.impl.Speller_fr;

/**
 * @author Peter De Bruycker
 */
public class Speller_frTest {

    @Test
    public void test() {
        Speller_fr speller = new Speller_fr();

        assertEquals("zéro", speller.spell(0, 0));
        assertEquals("neuf", speller.spell(9, 0));
        assertEquals("dix-neuf", speller.spell(19, 0));
        assertEquals("vingt et un", speller.spell(21, 0));
        assertEquals("vingt-huit", speller.spell(28, 0));
        assertEquals("soixante et onze", speller.spell(71, 0));
        assertEquals("soixante-douze", speller.spell(72, 0));
        assertEquals("quatre-vingt", speller.spell(80, 0));
        assertEquals("quatre-vingt-un", speller.spell(81, 0));
        assertEquals("quatre-vingt-neuf", speller.spell(89, 0));
        assertEquals("quatre-vingt-dix", speller.spell(90, 0));
        assertEquals("quatre-vingt-onze", speller.spell(91, 0));
        assertEquals("quatre-vingt-dix-sept", speller.spell(97, 0));
        assertEquals("cent", speller.spell(100, 0));
        assertEquals("cent un", speller.spell(101, 0));
        assertEquals("cent dix", speller.spell(110, 0));
        assertEquals("cent vingt", speller.spell(120, 0));
        assertEquals("deux cents", speller.spell(200, 0));
        assertEquals("deux cent un", speller.spell(201, 0));
        assertEquals("deux cent trente-deux", speller.spell(232, 0));
        assertEquals("neuf cent quatre-vingt-dix-neuf", speller.spell(999, 0));
        assertEquals("mille", speller.spell(1000, 0));
        assertEquals("mille un", speller.spell(1001, 0));
        assertEquals("dix mille", speller.spell(10000, 0));
        assertEquals("dix mille un", speller.spell(10001, 0));
        assertEquals("cent mille", speller.spell(100000, 0));
        assertEquals("deux millions", speller.spell(2000000, 0));
        assertEquals("trois milliards", speller.spell(3000000000L, 0));
    }
}

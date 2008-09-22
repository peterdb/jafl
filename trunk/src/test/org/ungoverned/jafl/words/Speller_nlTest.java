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

import java.math.BigDecimal;

import org.junit.Test;
import org.ungoverned.jafl.words.impl.Speller_nl;

/**
 * @author Peter De Bruycker
 */
public class Speller_nlTest {

    @Test
    public void testKommaGetallen() {
        Speller_nl speller = new Speller_nl();

        assertEquals("duizend tweehonderdvierendertig komma vijfenvijftig", speller.spell(new BigDecimal("1234.55"), 2));
        assertEquals("duizend tweehonderdvierendertig komma nul", speller.spell(1234.0, 2));
        assertEquals("achtennegentigduizend tweehonderdvierendertig komma negentig", speller.spell(98234.9, 2));

        assertEquals("nul komma vijfenvijftig", speller.spell(0.558875654, 2));

    }

    @Test
    public void testGeheleGetallen() {
        Speller_nl speller = new Speller_nl();

        assertEquals("nul", speller.spell(0, 0));
        assertEquals("twee", speller.spell(2, 0));
        assertEquals("drie", speller.spell(3, 0));
        assertEquals("duizend", speller.spell(1000, 0));
        assertEquals("eenendertig", speller.spell(31, 0));
        assertEquals("tweeduizend", speller.spell(2000, 0));
        assertEquals("vijfentwintig", speller.spell(25, 0));
        assertEquals("een miljoen tweehonderdvierendertigduizend vijfhonderdzevenenzestig", speller.spell(1234567, 0));
        assertEquals("twee miljoen tweehonderdtweeëntwintigduizend tweehonderdtweeëntwintig", speller.spell(2222222, 0));
        assertEquals("honderdelfduizend honderdelf", speller.spell(111111, 0));
        assertEquals("zevenendertig miljoen honderdvijfendertigduizend zevenhonderdachtennegentig", speller.spell(
                37135798, 0));
        assertEquals("zeventienduizend tweehonderddertien", speller.spell(17213, 0));
    }
}

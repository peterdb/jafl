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

import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.junit.Test;
import org.ungoverned.jafl.words.impl.Speller;
import org.ungoverned.jafl.words.impl.Speller_en;
import org.ungoverned.jafl.words.impl.Speller_fr;
import org.ungoverned.jafl.words.impl.Speller_nl;

/**
 * Test case for testing {@link Locale} specific loading of {@link Speller}s
 * 
 * @author Peter De Bruycker
 */
public class SpellerTest {
    @Test
    public void getSpeller() {
        assertTrue(Speller.getSpeller(Locale.FRANCE) instanceof Speller_fr);
        assertTrue(Speller.getSpeller(Locale.ENGLISH) instanceof Speller_en);
        assertTrue(Speller.getSpeller(new Locale("nl")) instanceof Speller_nl);
    }

    @Test
    public void getSpellerWithUnknownLocaleReturnsDefaultLocale() {
        assertTrue(Speller.getSpeller(new Locale("zz")).equals(Speller.getSpeller()));
    }
}

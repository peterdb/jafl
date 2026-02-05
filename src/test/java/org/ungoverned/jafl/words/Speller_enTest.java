package org.ungoverned.jafl.words;

/*-
 * #%L
 * Java Advanced Formatting Library (JAFL)
 * %%
 * Copyright (C) 2008 - 2026 Peter De Bruycker
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

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

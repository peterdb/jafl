package io.github.jafl.words;

/*-
 * #%L
 * Java Advanced Formatting Library (JAFL)
 * %%
 * Copyright (C) 2008 - 2026 Java Advanced Formatting Library (JAFL) Contributors
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
import io.github.jafl.words.impl.Speller_fr;

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

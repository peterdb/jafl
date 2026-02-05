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

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

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

import org.ungoverned.jafl.words.impl.Speller;

/**
 * {@link NumberFormat} implementation for spelling out numbers.
 * 
 * @author Peter De Bruycker
 */
public class SpellerNumberFormat extends NumberFormat {

    private static final long serialVersionUID = 1L;

    private int precision;
    private Speller speller;

    /**
     * Create a new {@link SpellerNumberFormat} with the {@link Speller} for the default {@link Locale}, and zero
     * precision
     */
    public SpellerNumberFormat() {
        this(0);
    }

    /**
     * Create a new {@link SpellerNumberFormat} with the {@link Speller} for the default {@link Locale}, and the given
     * precision
     * 
     * @param precision the precision
     */
    public SpellerNumberFormat(int precision) {
        this(Locale.getDefault(), precision);
    }

    /**
     * Create a new {@link SpellerNumberFormat} with the {@link Speller} for the given {@link Locale}, and the given
     * precision
     * 
     * @param locale the {@link Locale}
     * @param precision the precision
     */
    public SpellerNumberFormat(Locale locale, int precision) {
        this(Speller.getSpeller(locale), precision);
    }

    /**
     * Create a new {@link SpellerNumberFormat} with the given {@link Speller}, and zero precision
     * 
     * @param speller the {@link Speller}
     */
    public SpellerNumberFormat(Speller speller) {
        this(speller, 0);
    }

    /**
     * Create a new {@link SpellerNumberFormat} with the given {@link Speller}, and the given precision
     * 
     * @param speller the {@link Speller}
     * @param precision the precision
     */
    public SpellerNumberFormat(Speller speller, int precision) {
        // TODO assert speller not null
        // TODO assert precision >= 0
        
        this.precision = precision;
        this.speller = speller;
    }

    @Override
    public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
        toAppendTo.append(speller.spell(number, precision));

        return toAppendTo;
    }

    @Override
    public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
        toAppendTo.append(speller.spell(number, precision));

        return toAppendTo;
    }

    @Override
    public Number parse(String source, ParsePosition parsePosition) {
        throw new UnsupportedOperationException("not yet implemented");
    }

}

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

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
package org.ungoverned.jafl.roman;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * {@link NumberFormat} implementation for formatting/parsing roman numerals.
 * <p>
 * Uses an algorithm inspired by http://www.geocities.com/oosterwal/computer/string.html
 * <p>
 * TODO parse "" as zero
 * 
 * @author Peter De Bruycker
 */
public class RomanNumeralNumberFormat extends NumberFormat {

    private static final long serialVersionUID = 1L;

    private static final Map<String, Integer> roman2numeric = new LinkedHashMap<String, Integer>();

    {
        roman2numeric.put("M", 1000);
        roman2numeric.put("CM", 900);
        roman2numeric.put("D", 500);
        roman2numeric.put("CD", 400);
        roman2numeric.put("C", 100);
        roman2numeric.put("XC", 90);
        roman2numeric.put("L", 50);
        roman2numeric.put("XL", 40);
        roman2numeric.put("X", 10);
        roman2numeric.put("IX", 9);
        roman2numeric.put("V", 5);
        roman2numeric.put("IV", 4);
        roman2numeric.put("I", 1);
    }

    @Override
    public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
        throw new IllegalArgumentException("Unable to format a double as a roman numeral");
    }

    @Override
    public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
        // TODO number must be short, integer, long or BigInteger, else throw IllegalArgumentException
        // TODO number must be smaller than 4000, else throw IllegalArgumentException

        int input = (int) number;

        for (Entry<String, Integer> entry : roman2numeric.entrySet()) {
            int tmp = input / entry.getValue();

            for (int i = 0; i < tmp; i++) {
                toAppendTo.append(entry.getKey());
            }

            input -= tmp * entry.getValue();
        }

        return toAppendTo;
    }

    @Override
    public Number parse(String source) throws ParseException {
        if (source.length() == 0) {
            return 0;
        }

        return super.parse(source);
    }

    @Override
    public Number parse(String source, ParsePosition parsePosition) {
        int value = 0;

        int previous = 0;
        for (int i = 0; i < source.length(); i++) {
            parsePosition.setIndex(i + 1);

            String c = String.valueOf(source.charAt(i));

            if (!roman2numeric.containsKey(c)) {
                parsePosition.setErrorIndex(i);
                parsePosition.setIndex(0);
                return null;
            }

            int current = roman2numeric.get(c);
            value += current;
            if (current > previous) {
                value -= 2 * previous;
            }

            previous = current;
        }

        return value;
    }
}

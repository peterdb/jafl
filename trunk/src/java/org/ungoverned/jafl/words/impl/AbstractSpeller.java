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
package org.ungoverned.jafl.words.impl;

import java.math.BigDecimal;

/**
 * Abstract base class for {@link Speller} implementations.
 * 
 * @author Peter De Bruycker
 */
public abstract class AbstractSpeller extends Speller {

    private String decimalPoint;
    private String zero;
    private String negative;

    /**
     * @param negative the string to use for the sign
     * @param decimalPoint the string to use for the decimal point
     * @param zero the string to use for zero
     */
    public AbstractSpeller(String negative, String decimalPoint, String zero) {
        this.negative = negative;
        this.decimalPoint = decimalPoint;
        this.zero = zero;
    }

    public final String spell(Number number, int precision) {
        StringBuilder sb = new StringBuilder();

        if (number.doubleValue() < 0) {
            sb.append(negative).append(" ");
        }
        sb.append(spellZeroSafe(number.longValue()));

        if (precision > 0) {
            sb.append(" ").append(decimalPoint).append(" ");

            long decimals = new BigDecimal(number.toString()).subtract(new BigDecimal(number.longValue()))
                    .movePointRight(precision).longValue();

            sb.append(spellZeroSafe(decimals));
        }

        return sb.toString().trim();
    }

    private String spellZeroSafe(long number) {
        if (number == 0) {
            return zero;
        } else {
            return doSpell(Math.abs(number));
        }
    }

    protected abstract String doSpell(long number);
}

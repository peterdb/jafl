package org.ungoverned.jafl.words.impl;

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

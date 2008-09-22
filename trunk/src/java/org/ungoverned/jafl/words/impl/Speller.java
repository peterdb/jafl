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

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Strategy for spelling numbers given a precision.
 * <p>
 * Extends from {@link ListResourceBundle} so we can load {@link Locale}-specific {@link Speller} implementations.
 * 
 * @see #spell(Number, int)
 * 
 * @author Peter De Bruycker
 */
public abstract class Speller extends ListResourceBundle {

    public static Speller getSpeller() {
        return getSpeller(Locale.getDefault());
    }

    public static Speller getSpeller(Locale locale) {
        return (Speller) ResourceBundle.getBundle(Speller.class.getName(), locale);
    }

    public abstract String spell(Number number, int precision);

    @Override
    protected final Object[][] getContents() {
        return null;
    }
}

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

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

/**
 * Test values taken from http://en.wikipedia.org/wiki/Roman_numerals#Modern_Roman_numerals
 * 
 * @author Peter De Bruycker
 */
public class RomanNumeralNumberFormatTest {
    @Test
    public void testFormat() {
        RomanNumeralNumberFormat format = new RomanNumeralNumberFormat();

        assertEquals("", format.format(0));
        assertEquals("I", format.format(1));
        assertEquals("II", format.format(2));
        assertEquals("III", format.format(3));
        assertEquals("IV", format.format(4));
        assertEquals("V", format.format(5));
        assertEquals("VI", format.format(6));
        assertEquals("VII", format.format(7));
        assertEquals("VIII", format.format(8));
        assertEquals("IX", format.format(9));
        assertEquals("X", format.format(10));
        assertEquals("XI", format.format(11));
        assertEquals("XII", format.format(12));
        assertEquals("XIII", format.format(13));
        assertEquals("XIV", format.format(14));
        assertEquals("XV", format.format(15));
        assertEquals("XVI", format.format(16));
        assertEquals("XVII", format.format(17));
        assertEquals("XVIII", format.format(18));
        assertEquals("XIX", format.format(19));
        assertEquals("XX", format.format(20));
        assertEquals("XXI", format.format(21));
        assertEquals("XXV", format.format(25));
        assertEquals("XXX", format.format(30));
        assertEquals("XL", format.format(40));
        assertEquals("XLV", format.format(45));
        assertEquals("XLIX", format.format(49));
        assertEquals("L", format.format(50));
        assertEquals("LX", format.format(60));
        assertEquals("LXIX", format.format(69));
        assertEquals("LXX", format.format(70));
        assertEquals("LXXX", format.format(80));
        assertEquals("XC", format.format(90));
        assertEquals("XCIX", format.format(99));
        assertEquals("C", format.format(100));
        assertEquals("CC", format.format(200));
        assertEquals("CCC", format.format(300));
        assertEquals("CD", format.format(400));
        assertEquals("D", format.format(500));
        assertEquals("DC", format.format(600));
        assertEquals("DCLXVI", format.format(666));
        assertEquals("DCC", format.format(700));
        assertEquals("DCCC", format.format(800));
        assertEquals("CM", format.format(900));
        assertEquals("M", format.format(1000));
        assertEquals("MCDXLIV", format.format(1444));
        assertEquals("MDCLXVI", format.format(1666));
        assertEquals("MCMXLV", format.format(1945));
        assertEquals("MCMXCVII", format.format(1997));
        assertEquals("MCMXCIX", format.format(1999));
        assertEquals("MM", format.format(2000));
        assertEquals("MMVIII", format.format(2008));
        assertEquals("MMD", format.format(2500));
        assertEquals("MMM", format.format(3000));
    }

    @Test
    public void testParseEmptyStringReturnsZero() throws ParseException {
        RomanNumeralNumberFormat format = new RomanNumeralNumberFormat();

        assertEquals(0, format.parse(""));
    }

    @Test(expected = ParseException.class)
    public void testInvalidCharacters() throws ParseException {
        RomanNumeralNumberFormat format = new RomanNumeralNumberFormat();

        format.parse("ABC");
    }

    @Test
    public void testParse() throws ParseException {
        RomanNumeralNumberFormat format = new RomanNumeralNumberFormat();

        assertEquals(1, format.parse("I"));
        assertEquals(2, format.parse("II"));
        assertEquals(3, format.parse("III"));
        assertEquals(4, format.parse("IV"));
        assertEquals(5, format.parse("V"));
        assertEquals(6, format.parse("VI"));
        assertEquals(7, format.parse("VII"));
        assertEquals(8, format.parse("VIII"));
        assertEquals(9, format.parse("IX"));
        assertEquals(10, format.parse("X"));
        assertEquals(11, format.parse("XI"));
        assertEquals(12, format.parse("XII"));
        assertEquals(13, format.parse("XIII"));
        assertEquals(14, format.parse("XIV"));
        assertEquals(15, format.parse("XV"));
        assertEquals(16, format.parse("XVI"));
        assertEquals(17, format.parse("XVII"));
        assertEquals(18, format.parse("XVIII"));
        assertEquals(19, format.parse("XIX"));
        assertEquals(20, format.parse("XX"));
        assertEquals(21, format.parse("XXI"));
        assertEquals(25, format.parse("XXV"));
        assertEquals(30, format.parse("XXX"));
        assertEquals(40, format.parse("XL"));
        assertEquals(45, format.parse("XLV"));
        assertEquals(49, format.parse("XLIX"));
        assertEquals(50, format.parse("L"));
        assertEquals(60, format.parse("LX"));
        assertEquals(69, format.parse("LXIX"));
        assertEquals(70, format.parse("LXX"));
        assertEquals(80, format.parse("LXXX"));
        assertEquals(90, format.parse("XC"));
        assertEquals(99, format.parse("XCIX"));
        assertEquals(100, format.parse("C"));
        assertEquals(200, format.parse("CC"));
        assertEquals(300, format.parse("CCC"));
        assertEquals(400, format.parse("CD"));
        assertEquals(500, format.parse("D"));
        assertEquals(600, format.parse("DC"));
        assertEquals(666, format.parse("DCLXVI"));
        assertEquals(700, format.parse("DCC"));
        assertEquals(800, format.parse("DCCC"));
        assertEquals(900, format.parse("CM"));
        assertEquals(1000, format.parse("M"));
        assertEquals(1444, format.parse("MCDXLIV"));
        assertEquals(1666, format.parse("MDCLXVI"));
        assertEquals(1945, format.parse("MCMXLV"));
        assertEquals(1997, format.parse("MCMXCVII"));
        assertEquals(1999, format.parse("MCMXCIX"));
        assertEquals(2000, format.parse("MM"));
        assertEquals(2008, format.parse("MMVIII"));
        assertEquals(2500, format.parse("MMD"));
        assertEquals(3000, format.parse("MMM"));
    }
}

# Java Advanced Formatting Library (JAFL)

[![CI](https://github.com/peterdb/jafl/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/peterdb/jafl/actions/workflows/maven.yml?query=branch%3Amain)

The Java Advanced Formatting Library (JAFL) gives you specialized `java.text.NumberFormat` implementations.

Currently, there's support for: 
- RomanNumerals
- NumbersInWords

## Installation

TODO

## Numbers in Words

Supported languages: currently only Dutch, English and French are supported.

Usage:

Use `SpellerNumberFormat`, using one of the constructors (either pass nothing, a `Locale` or a specific `Speller`).

The precision defines how many decimals will be spelled.

Create a Dutch format, with 2 decimals: 

    SpellerNumberFormat format = new SpellerNumberFormat(new Locale("nl"), 2);

    assert "honderddrieëntwintig komma vijfenveertig".equals(format.format(123.45));
    assert "honderddrieëntwintig komma nul".equals(format.format(123.0));

This creates a format for French, with no decimals:

    SpellerNumberFormat format = new SpellerNumberFormat(Locale.FRENCH);

    assert "cent vingt-trois".equals(format.format(123));

## Roman Numerals

Use the `RomanNumeralNumberFormat` to parse and format numbers to roman numerals.

    RomanNumeralNumberFormat format = new RomanNumeralNumberFormat();

    // formatting
    assert "I".equals(format.format(1);
    assert "IV".equals(format.format(4);

    // parsing 
    assert 1 == format.parse("I");
    assert 4 == format.parse("IV");

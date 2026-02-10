# Java Advanced Formatting Library (JAFL)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java 17+](https://img.shields.io/badge/Java-17%2B-blue)](https://adoptium.net/)
[![CI](https://github.com/peterdb/jafl/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/peterdb/jafl/actions/workflows/maven.yml?query=branch%3Amain)

The Java Advanced Formatting Library (JAFL) gives you specialized `java.text.NumberFormat` implementations.

## Installation

TODO

## Formatters/Parsers

Currently, these formatters/parsers are implemented:

| Name                                  | Formatting | Parsing |
|---------------------------------------|------------|---------|
| [Numbers in words](#numbers-in-words) | yes        | no      |
| [Roman numerals](#roman-numerals)     | yes        | yes     |

### Numbers in Words

Supported languages: currently only Dutch, English and French are supported.

Usage:

Use `SpellerNumberFormat`, using one of the constructors (either pass nothing for the default `Locale`, a specific `Locale` or a specific `Speller`).

The precision defines how many decimals will be spelled.

Create a Dutch format, with 2 decimals: 

```java
SpellerNumberFormat format = new SpellerNumberFormat(new Locale("nl"), 2);

assert "honderddrieëntwintig komma vijfenveertig".equals(format.format(123.45));
assert "honderddrieëntwintig komma nul".equals(format.format(123.0));
```

This creates a format for French, with no decimals:

```java
SpellerNumberFormat format = new SpellerNumberFormat(Locale.FRENCH);

assert "cent vingt-trois".equals(format.format(123));
```

### Roman Numerals

Use the `RomanNumeralNumberFormat` to parse and format numbers to roman numerals.

```java
RomanNumeralNumberFormat format = new RomanNumeralNumberFormat();
```

Formatting:

```java
assert "I".equals(format.format(1);
assert "IV".equals(format.format(4);
```

Parsing:

```java
assert 1 == format.parse("I");
assert 4 == format.parse("IV");
```

## License

MIT
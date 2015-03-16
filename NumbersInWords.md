# Introduction #
Format numbers in words.

# Supported Languages #

Currently only Dutch, English and French are supported.

# Code #

Use `SpellerNumberFormat`, using one of the constructors (either pass nothing, a `Locale` or a specific `Speller`).

The precision defines how many decimals will be spelled.

Create a Dutch format, with 2 decimals:
```
SpellerNumberFormat format = new SpellerNumberFormat(new Locale("nl"), 2);

assert "honderddrieëntwintig komma vijfenveertig".equals(format.format(123.45));
assert "honderddrieëntwintig komma nul".equals(format.format(123.0));
```

This creates a format for French, with no decimals:
```
SpellerNumberFormat format = new SpellerNumberFormat(Locale.FRENCH);

assert "cent vingt-trois".equals(format.format(123));
```
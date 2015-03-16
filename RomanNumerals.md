Use the `org.ungoverned.jafl.RomanNumeralNumberFormat` to parse and format numbers to roman numerals.

```
RomanNumeralNumberFormat format = new RomanNumeralNumberFormat();

// formatting
assert "I".equals(format.format(1);
assert "IV".equals(format.format(4);

// parsing
assert 1 == format.parse("I");
assert 4 == format.parse("IV");
```
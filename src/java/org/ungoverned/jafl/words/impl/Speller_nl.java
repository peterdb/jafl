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

/**
 * {@link Speller} implementation for Dutch.
 * 
 * @author Peter De Bruycker
 */
public class Speller_nl extends AbstractSpeller {

    private static final String[] kleinerDan20 = new String[] { "", "een", "twee", "drie", "vier", "vijf", "zes",
            "zeven", "acht", "negen", "tien", "elf", "twaalf", "dertien", "veertien", "vijftien", "zestien",
            "zeventien", "achtien", "negentien" };

    private static final String[] tientallen = new String[] { "", "tien", "twintig", "dertig", "veertig", "vijftig",
            "zestig", "zeventig", "tachtig", "negentig" };

    private static final String[] machtenVanDuizend = new String[] { "", "duizend", " miljoen", " miljard" };

    public Speller_nl() {
        super("min", "komma", "nul");
    }

    private String spellSmallerThanThousand(final int value) {
        if (value == 0) {
            return "";
        }

        int rest = value;

        StringBuilder sb = new StringBuilder();

        // honderdtallen
        if (rest > 100) {
            int honderdtal = rest / 100;
            if (honderdtal > 1) {
                sb.append(kleinerDan20[honderdtal]);
            }
            sb.append("honderd");

            rest = rest % 100;
        }

        // tientallen en eenheden
        if (rest > 20) {
            int eenheden = rest % 10;
            sb.append(kleinerDan20[eenheden]);
            if (eenheden > 0 && rest > 20) {
                if (eenheden == 2 || eenheden == 3) {
                    sb.append("ën");
                } else {
                    sb.append("en");
                }
            }

            int tiental = rest / 10;
            sb.append(tientallen[tiental]);

            rest = rest % 10;
        } else {
            sb.append(kleinerDan20[rest]);
        }

        return sb.toString();
    }

    private static int[] split(long getal) {
        int numOfDigits = String.valueOf(getal).length();
        int numOfParts = (numOfDigits - 1) / 3 + 1;

        int[] result = new int[numOfParts];
        for (int i = 0; i < numOfParts; i++) {
            result[i] = (int) (getal / (long) Math.pow(1000, numOfParts - i - 1));
            getal = getal % (long) Math.pow(1000, numOfParts - i - 1);
        }

        return result;
    }

    protected String doSpell(long value) {
        StringBuilder resultaat = new StringBuilder();

        int[] gesplitst = split(value);
        for (int i = 0; i < gesplitst.length; i++) {
            // "een duizend" bestaat niet
            if (i == gesplitst.length - 2 && gesplitst[i] > 1 || i != gesplitst.length - 2) {
                resultaat.append(spellSmallerThanThousand(gesplitst[i]));
            }
            resultaat.append(machtenVanDuizend[gesplitst.length - i - 1]).append(' ');
        }

        return resultaat.toString().trim();
    }
}

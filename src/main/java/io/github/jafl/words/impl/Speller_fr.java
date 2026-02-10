package io.github.jafl.words.impl;

/*-
 * #%L
 * Java Advanced Formatting Library (JAFL)
 * %%
 * Copyright (C) 2008 - 2026 Java Advanced Formatting Library (JAFL) Contributors
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

import java.text.DecimalFormat;

/**
 * {@link Speller} implementation for French.
 *
 * @author Peter De Bruycker
 */
public class Speller_fr extends AbstractSpeller {

    private static final String[] dizaineNames = { "", "", "vingt", "trente", "quarante", "cinquante", "soixante",
            "soixante", "quatre-vingt", "quatre-vingt" };

    private static final String[] uniteNames1 = { "", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit",
            "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf" };

    private static final String[] uniteNames2 = { "", "", "deux", "trois", "quatre", "cinq", "six", "sept", "huit",
            "neuf", "dix" };

    public Speller_fr() {
        super("???", "???", "zéro");
    }

    private String spellZeroToHundred(int number) {

        int laDizaine = number / 10;
        int lUnite = number % 10;
        String resultat = "";

        switch (laDizaine) {
            case 1:
            case 7:
            case 9:
                lUnite = lUnite + 10;
                break;
            default:
        }

        // séparateur "-" "et" ""
        String laLiaison = "";
        if (laDizaine > 1) {
            laLiaison = "-";
        }
        // cas particuliers
        switch (lUnite) {
            case 0:
                laLiaison = "";
                break;
            case 1:
                if (laDizaine == 8) {
                    laLiaison = "-";
                } else {
                    laLiaison = " et ";
                }
                break;
            case 11:
                if (laDizaine == 7) {
                    laLiaison = " et ";
                }
                break;
            default:
        }

        // dizaines en lettres
        switch (laDizaine) {
            case 0:
                resultat = uniteNames1[lUnite];
                break;
            case 8:
                if (lUnite == 0) {
                    resultat = dizaineNames[laDizaine];
                } else {
                    resultat = dizaineNames[laDizaine] + laLiaison + uniteNames1[lUnite];
                }
                break;
            default:
                resultat = dizaineNames[laDizaine] + laLiaison + uniteNames1[lUnite];
        }

        return resultat;
    }

    private String spellLessThanOneThousand(int number) {

        int lesCentaines = number / 100;
        int leReste = number % 100;
        String sReste = spellZeroToHundred(leReste);

        String resultat;
        switch (lesCentaines) {
            case 0:
                resultat = sReste;
                break;
            case 1:
                if (leReste > 0) {
                    resultat = "cent " + sReste;
                } else {
                    resultat = "cent";
                }
                break;
            default:
                if (leReste > 0) {
                    resultat = uniteNames2[lesCentaines] + " cent " + sReste;
                } else {
                    resultat = uniteNames2[lesCentaines] + " cents";
                }
        }
        return resultat;
    }

    // 0 à 999 999 999 999
    protected String doSpell(long number) {
        String snumber = Long.toString(number);

        // pad des "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // XXXnnnnnnnnn
        int lesMilliards = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXXnnnnnn
        int lesMillions = Integer.parseInt(snumber.substring(3, 6));
        // nnnnnnXXXnnn
        int lesCentMille = Integer.parseInt(snumber.substring(6, 9));
        // nnnnnnnnnXXX
        int lesMille = Integer.parseInt(snumber.substring(9, 12));

        String tradMilliards;
        switch (lesMilliards) {
            case 0:
                tradMilliards = "";
                break;
            case 1:
                tradMilliards = spellLessThanOneThousand(lesMilliards) + " milliard ";
                break;
            default:
                tradMilliards = spellLessThanOneThousand(lesMilliards) + " milliards ";
        }
        String resultat = tradMilliards;

        String tradMillions;
        switch (lesMillions) {
            case 0:
                tradMillions = "";
                break;
            case 1:
                tradMillions = spellLessThanOneThousand(lesMillions) + " million ";
                break;
            default:
                tradMillions = spellLessThanOneThousand(lesMillions) + " millions ";
        }
        resultat = resultat + tradMillions;

        String tradCentMille;
        switch (lesCentMille) {
            case 0:
                tradCentMille = "";
                break;
            case 1:
                tradCentMille = "mille ";
                break;
            default:
                tradCentMille = spellLessThanOneThousand(lesCentMille) + " mille ";
        }
        resultat = resultat + tradCentMille;

        String tradMille;
        tradMille = spellLessThanOneThousand(lesMille);
        resultat = resultat + tradMille;

        return resultat;
    }
}

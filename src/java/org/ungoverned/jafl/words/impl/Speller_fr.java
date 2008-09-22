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

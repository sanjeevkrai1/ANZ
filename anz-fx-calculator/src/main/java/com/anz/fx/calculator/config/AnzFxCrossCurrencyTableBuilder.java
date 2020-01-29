package com.anz.fx.calculator.config;

import com.anz.fx.calculator.costants.AnzFxConstants;
import com.anz.fx.calculator.costants.AnzFxCurrencies;

/**
 * In order to help with the conversion, Configurtion of "cross-via" matrix may help. 
 * "Base" currencies are down the left, "terms" currencies across the top.
 * @author Sanjeev Rai
 *
 */
public class AnzFxCrossCurrencyTableBuilder {
    static String[][] crossCurrencytable = null;

    /**
     *  Build Cross-via matrix
     * @return String [][]
     */
    public static String[][] build() {

        if (crossCurrencytable == null) {
            crossCurrencytable = new String[AnzFxCurrencies.values().length][AnzFxCurrencies.values().length];
            int i = 0, j = 0;

            //AUD
            crossCurrencytable[i][j++] = AnzFxConstants.SAME_CURRENCY;
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.DIRECT;
            i++;
            j = 0;

            //CAD
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.SAME_CURRENCY;
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.DIRECT;
            i++;
            j = 0;

            //CNY
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.SAME_CURRENCY;
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.DIRECT;
            i++;
            j = 0;

            //CZK
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.SAME_CURRENCY;
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            crossCurrencytable[i][j++] = AnzFxConstants.INVERSE;
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            i++;
            j = 0;

            //DKK
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            crossCurrencytable[i][j++] = AnzFxConstants.SAME_CURRENCY;
            crossCurrencytable[i][j++] = AnzFxConstants.INVERSE;
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            i++;
            j = 0;

            //EUR
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.DIRECT;
            crossCurrencytable[i][j++] = AnzFxConstants.DIRECT;
            crossCurrencytable[i][j++] = AnzFxConstants.SAME_CURRENCY;
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.DIRECT;
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.DIRECT;
            i++;
            j = 0;

            //GBP
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.SAME_CURRENCY;
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.DIRECT;
            i++;
            j = 0;

            //JPY
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.SAME_CURRENCY;
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.INVERSE;
            i++;
            j = 0;

            //NOK
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            crossCurrencytable[i][j++] = AnzFxConstants.INVERSE;
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.SAME_CURRENCY;
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            i++;
            j = 0;

            //NZD
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.USD.name();
            crossCurrencytable[i][j++] = AnzFxConstants.SAME_CURRENCY;
            crossCurrencytable[i][j++] = AnzFxConstants.DIRECT;
            i++;
            j = 0;

            //USD
            crossCurrencytable[i][j++] = AnzFxConstants.INVERSE;
            crossCurrencytable[i][j++] = AnzFxConstants.INVERSE;
            crossCurrencytable[i][j++] = AnzFxConstants.INVERSE;
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            crossCurrencytable[i][j++] = AnzFxConstants.INVERSE;
            crossCurrencytable[i][j++] = AnzFxConstants.INVERSE;
            crossCurrencytable[i][j++] = AnzFxConstants.DIRECT;
            crossCurrencytable[i][j++] = AnzFxCurrencies.EUR.name();
            crossCurrencytable[i][j++] = AnzFxConstants.INVERSE;
            crossCurrencytable[i][j++] = AnzFxConstants.SAME_CURRENCY;
        }
        return crossCurrencytable;
    }
}

package com.baha.currencyconverter;

import java.util.ArrayList;

public class Converter {

    public ArrayList<Currency> currencies = new ArrayList<>();

    public Converter() {
        init();
    }

    private void init() {
        currencies.add(new Currency("KGS", 1.0, R.drawable.kgz));
        currencies.add(new Currency("USD", 69.0, R.drawable.usa));
        currencies.add(new Currency("TRY", 11.31, R.drawable.turkey));
        currencies.add(new Currency("KZT", 0.18, R.drawable.kz));
        currencies.add(new Currency("EUR", 78.36, R.drawable.ger));
    }

    public double convert(Object from, Object to, double amount) {
        double fromA = currencies.get(findFromArray(from)).getPrice();
        double toA = currencies.get(findFromArray(to)).getPrice();

        return fromA / toA * amount;
    }

    private int findFromArray(Object target) {
        for (int i = 0; i < currencies.size(); i++ ) {
            if (currencies.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Currency> getCurrents() {
        return currencies;
    }
}

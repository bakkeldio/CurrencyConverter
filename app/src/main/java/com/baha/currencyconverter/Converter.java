package com.baha.currencyconverter;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public List<String> names = new ArrayList<>();
    private List<Double> currents = new ArrayList<>();

    public Converter() {
        init();
    }

    private void init() {
        names.add("KGS");
        names.add("USD");
        names.add("EU");
        names.add("KZT");

        currents.add(1.0);
        currents.add(69.0);
        currents.add(78.05);
        currents.add(0.18);
    }

    public double convert(String from, String to, double amount) {
        double fromA = currents.get(findFromArray(from));
        double toA = currents.get(findFromArray(to));

        return fromA / toA * amount;
    }

    private int findFromArray(String name) {
        for (int i = 0; i < names.size(); i++ ) {
            if (names.get(i).equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public List<String> getCurrents() {
        return names;
    }
}

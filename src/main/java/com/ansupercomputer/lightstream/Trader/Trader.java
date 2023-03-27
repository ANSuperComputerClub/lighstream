package com.ansupercomputer.lightstream.Trader;

import com.ansupercomputer.lightstream.Util.Identifiable;

public class Trader implements Identifiable {
    private String identifier;

    private Portfolio portfolio;

    @Override
    public String getIdentifier() {
        return identifier;
    }
}

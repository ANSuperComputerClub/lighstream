package com.ansupercomputer.lightstream.Trader;

import com.ansupercomputer.lightstream.Asset.Asset;
import com.ansupercomputer.lightstream.Exceptions.AssetNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Portfolio {
    private final HashMap<Asset, Double> assets;

    public Portfolio() {
        this.assets = new HashMap<>();
    }

    public Portfolio(HashMap<Asset, Double> assets) {
        this.assets = assets;
    }

    public void addEntry(Asset asset, Double quantity) {
        assets.put(asset, quantity);
    }

    public HashMap<Asset, Double> getAllEntries() {
        return assets;
    }

    public Double getQuantity(Asset asset) {
        return assets.get(asset);
    }
}

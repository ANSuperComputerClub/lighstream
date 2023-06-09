package com.ansupercomputer.lightstream.Asset;

import com.ansupercomputer.lightstream.Exceptions.IllegalOperationException;
import com.ansupercomputer.lightstream.Util.Identifiable;
import com.ansupercomputer.lightstream.Util.PriceHistory;
import com.ansupercomputer.lightstream.Util.Unique;

import java.math.BigDecimal;

/**
 * Defines an Asset, or something that has a dynamic price and can be exchanged on the Market.
 */
public class Asset implements Unique, Identifiable {

    /**
     * Keeps track of unused ids
     */
    private static int nextId = 0;
    /**
     * An id unique to this asset
     */
    private final int id;
    /**
     * Stores the price history of the asset
     */
    private final PriceHistory priceHistory;
    private final String identifier;
    private BigDecimal price;

    /**
     * Creates an Asset
     *
     * @param price      The starting price of the Asset
     * @param identifier The identifier of the Asset
     */
    public Asset(BigDecimal price, String identifier) {
        id = nextId++;
        this.priceHistory = new PriceHistory();
        this.price = price;
        this.identifier = identifier;
    }

    /**
     * @return The price of the asset
     */
    public BigDecimal getPrice() throws IllegalOperationException {
        return price;
    }

    /**
     * @return The price history of the asset
     */
    public PriceHistory getPriceHistory() {
        return priceHistory;
    }

    /**
     * Updates the price and records the previous price in the priceHistory
     *
     * @param newPrice The new price
     */
    public void updatePrice(BigDecimal newPrice) throws IllegalOperationException {
        priceHistory.recordPrice(System.currentTimeMillis(), price);
        price = newPrice;
    }

    /**
     * @return The identifier of the object
     */
    @Override
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @return The objects unique id
     */
    @Override
    public int getId() {
        return id;
    }
}

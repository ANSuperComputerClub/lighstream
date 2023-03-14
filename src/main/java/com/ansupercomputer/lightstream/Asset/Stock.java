package com.ansupercomputer.lightstream.Asset;

import java.math.BigDecimal;

/**
 * Defines a Stock, which is an Asset sold on a stock exchange. Stocks describe a share of ownership of a company.
 */
public class Stock extends Asset {
    /**
     * Defines the total volume of stock available for purchase.
     * The total volume is later used when calculating the total value of the company
     * Value of company = stock price * total volume
     */
    private double totalVolume;

    /**
     * Stores the volume of stock available to purchase
     * This prevents infinite self-reinforcing loops by enforcing limits on how much a stock can be purchased.
     */
    private double availableVolume;

    /**
     * Creates a Stock
     *
     * @param price      The starting price of the Asset
     * @param identifier The identifier of the Asset
     */
    public Stock(BigDecimal price, String identifier) {
        super(price, identifier);
    }
}

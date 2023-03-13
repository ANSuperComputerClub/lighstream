package com.ansupercomputer.lightstream.Asset;

import com.ansupercomputer.lightstream.Exceptions.IllegalOperationException;

import java.math.BigDecimal;
import java.util.List;

/**
 * A Derivative Asset is an Asset that derives its price from another asset; e.g. Bread's price is determined by the price of wheat.
 */
public class Derivative extends Asset {
    /**
     * The underlying assets that the derivative price is based on
     */
    private final List<Asset> underlyingAssets;

    /**
     * The function that determines the relation between the derivative price and price of the underlying assets
     */
    private DerivativePricingFunction pricingFunction;
    /**
     * Creates a Derivative Asset
     * @param underlyingAssets The assets that the derivative asset relies on to get the price of
     * @param pricer           The function that determines the price of the derivative asset, given the price of the underlying asset
     * @param identifier       The identifier of the Asset
     */
    public Derivative(List<Asset> underlyingAssets, DerivativePricingFunction pricer, String identifier) throws IllegalOperationException {
        super(BigDecimal.valueOf(0), identifier);
        this.underlyingAssets = underlyingAssets;
        updatePrice();
    }

    /**
     * Calls the internal pricing function to determine the price of the asset.
     * @return the price of the derivative asset.
     */
    public BigDecimal getPrice() throws IllegalOperationException {
        // We decide to add to CPU Load in order to reduce memory usage... TODO: decide if this is the right decision or not
        updatePrice();
        return super.getPrice();
    }

    /**
     * Updates the price in accordance with
     */
    public void updatePrice() throws IllegalOperationException { super.updatePrice(pricingFunction.run(underlyingAssets)); }

    @Override
    public void updatePrice(BigDecimal newPrice) throws IllegalOperationException {
        throw new IllegalOperationException("Cannot directly update price of derivative asset");
    }

    @FunctionalInterface
    private interface DerivativePricingFunction {
        BigDecimal run(List<Asset> underlyingAssets);
    }
}

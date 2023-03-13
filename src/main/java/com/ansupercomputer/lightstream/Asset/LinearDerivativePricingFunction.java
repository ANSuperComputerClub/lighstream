package com.ansupercomputer.lightstream.Asset;

import com.ansupercomputer.lightstream.Exceptions.IllegalOperationException;

import java.math.BigDecimal;
import java.util.List;

public class LinearDerivativePricingFunction implements DerivativePricingFunction {

    private final List<BigDecimal> weights;

    public LinearDerivativePricingFunction(List<BigDecimal> weights) {
        this.weights = weights;
    }

    @Override
    public BigDecimal run(List<Asset> underlyingAssets) throws IllegalOperationException {
        if (underlyingAssets.size() != weights.size()) {
            throw new IllegalOperationException("Number of underlying assets and weights do not match");
        }

        BigDecimal price = BigDecimal.ZERO;
        for (int i = 0; i < underlyingAssets.size(); i++) {
            Asset underlyingAsset = underlyingAssets.get(i);
            BigDecimal weight = weights.get(i);
            price = price.add(underlyingAsset.getPrice().multiply(weight));
        }

        return price;
    }
}
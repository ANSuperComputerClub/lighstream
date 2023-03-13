package com.ansupercomputer.lightstream.Asset;

import com.ansupercomputer.lightstream.Exceptions.IllegalOperationException;

import java.math.BigDecimal;
import java.util.List;

@FunctionalInterface
public interface DerivativePricingFunction {
    BigDecimal run(List<Asset> underlyingAssets) throws IllegalOperationException;
}
package com.ansupercomputer.lightstream.Asset;

import com.ansupercomputer.lightstream.Exceptions.IllegalOperationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DerivativeTests {

    private Asset underlyingAsset1;
    private Derivative derivative;

    @BeforeEach
    void setUp() throws IllegalOperationException {
        underlyingAsset1 = new Asset(BigDecimal.valueOf(10), "UnderlyingAsset1");
        Asset underlyingAsset2 = new Asset(BigDecimal.valueOf(20), "UnderlyingAsset2");
        List<Asset> underlyingAssets = Arrays.asList(underlyingAsset1, underlyingAsset2);
        List<BigDecimal> weights = List.of(BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.5));
        DerivativePricingFunction pricingFunction = new LinearDerivativePricingFunction(weights);
        derivative = new Derivative(underlyingAssets, pricingFunction, "Derivative");
    }

    @Test
    void getPrice() throws IllegalOperationException {
        BigDecimal expectedPrice = BigDecimal.valueOf(15);
        BigDecimal actualPrice = derivative.getPrice();
        assert (expectedPrice.compareTo(actualPrice) == 0);
    }

    @Test
    void updatePrice() throws IllegalOperationException {
        BigDecimal newPrice = BigDecimal.valueOf(30);
        underlyingAsset1.updatePrice(newPrice);
        BigDecimal expectedPrice = BigDecimal.valueOf(25.0);
        BigDecimal actualPrice = derivative.getPrice();
        assert (expectedPrice.compareTo(actualPrice) == 0);
    }

    @Test
    void updatePrice_throwsException() {
        BigDecimal newPrice = BigDecimal.valueOf(30);
        assertThrows(IllegalOperationException.class, () -> derivative.updatePrice(newPrice));
    }
}
package com.ansupercomputer.lightstream.Util;

import java.math.BigDecimal;

@FunctionalInterface
public interface PricingFunction {
    BigDecimal run(BigDecimal previousPrice);
}

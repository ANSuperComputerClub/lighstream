package com.ansupercomputer.lightstream.Util;

import com.ansupercomputer.lightstream.Exceptions.InvalidArgumentException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Util {
    /**
     * Checks that the given value is in the specified range, otherwise throws an invalid argument exception
     * @param val the value to check
     * @param lower the lower bound (inclusive)
     * @param upper the upper bound (inclusive)
     */
    public static void enforceRange(double val, double lower, double upper) throws InvalidArgumentException {
        if(val > upper || val < lower) throw new InvalidArgumentException("Value must be between " + upper + " and " + lower);
    }
}

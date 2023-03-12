package com.ansupercomputer.lightstream.UtilTests;

import com.ansupercomputer.lightstream.Util.PriceHistory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@DisplayName("PriceHistory class tests")
class PriceHistoryTest {

    private PriceHistory priceHistory;

    @BeforeEach
    void setUp() {
        priceHistory = new PriceHistory();
    }

    @Test
    @DisplayName("recordPrice adds the specified price to the history")
    void recordPrice() {
        BigDecimal price = new BigDecimal("10.0");
        long time = System.currentTimeMillis();
        priceHistory.recordPrice(time, price);
        BigDecimal result = priceHistory.getPrice(time);
        Assertions.assertEquals(price, result);
    }

    @Test
    @DisplayName("getPrice returns the price closest to the specified time")
    void getPrice() {
        BigDecimal price1 = new BigDecimal("10.0");
        BigDecimal price2 = new BigDecimal("15.0");
        long time1 = System.currentTimeMillis();
        long time2 = time1 + 1000;
        priceHistory.recordPrice(time1, price1);
        priceHistory.recordPrice(time2, price2);
        BigDecimal result1 = priceHistory.getPrice(time1 + 200);
        BigDecimal result2 = priceHistory.getPrice(time2 - 200);
        Assertions.assertEquals(price1, result1);
        Assertions.assertEquals(price2, result2);
    }

    @Test
    @DisplayName("getPriceStream returns a stream of the object's price")
    void getPriceStream() {
        BigDecimal price1 = new BigDecimal("10.0");
        BigDecimal price2 = new BigDecimal("15.0");
        long time1 = System.currentTimeMillis();
        long time2 = time1 + 1000;
        priceHistory.recordPrice(time1, price1);
        priceHistory.recordPrice(time2, price2);
        var result = priceHistory.getPriceStream().toList();
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains(price1));
        Assertions.assertTrue(result.contains(price2));
    }

    @Test
    @DisplayName("getTimeStream returns a stream of the time at which the price is recorded")
    void getTimeStream() {
        BigDecimal price1 = new BigDecimal("10.0");
        BigDecimal price2 = new BigDecimal("15.0");
        long time1 = System.currentTimeMillis();
        long time2 = time1 + 1000;
        priceHistory.recordPrice(time1, price1);
        priceHistory.recordPrice(time2, price2);
        var result = priceHistory.getTimeStream().toList();
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains(time1));
        Assertions.assertTrue(result.contains(time2));
    }

    @Test
    @DisplayName("getHistory returns a stream of the entries in the price history")
    void getHistoryStream() {
        BigDecimal price1 = new BigDecimal("10.0");
        BigDecimal price2 = new BigDecimal("15.0");
        long time1 = System.currentTimeMillis();
        long time2 = time1 + 1000;
        priceHistory.recordPrice(time1, price1);
        priceHistory.recordPrice(time2, price2);
        var expected = new HashMap<Long, BigDecimal>();
        expected.put(time1, price1);
        expected.put(time2, price2);
        var result = priceHistory.getHistoryStream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Assertions.assertEquals(expected, result);
    }
}
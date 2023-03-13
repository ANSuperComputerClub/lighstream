package com.ansupercomputer.lightstream.Util;

import lombok.NonNull;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * A class that represents the price history of an object
 */
public class PriceHistory {
    private final HashMap<Long, BigDecimal> history;

    /**
     * Initializes a new price history object
     */
    public PriceHistory() {
        history = new HashMap<>();
    }

    /**
     * Initializes a new PriceHistory object based on the previous
     *
     * @param lhs the object to be copied
     */
    public PriceHistory(PriceHistory lhs) {
        history = lhs.history;
    }

    /**
     * Record a new price in the price history object
     *
     * @param time  The time to record
     * @param price The price to record
     */
    public void recordPrice(long time, BigDecimal price) {
        history.put(time, price);
    }

    /**
     * @param time The time at which the price should be fetched
     * @return The price closest to the specified time.
     */
    @NonNull
    public BigDecimal getPrice(long time) {
        long increment = -1;
        BigDecimal price = null;
        while (price == null) {
            increment++;
            price = history.get(time + increment);
            if (price == null) price = history.get(time - increment);
        }
        return price;
    }

    /**
     * @return A stream of the object's price
     */
    public Stream<BigDecimal> getPriceStream() {
        return history.values().stream();
    }

    /**
     * @return A stream of the time at which the price is recorded
     */
    public Stream<Long> getTimeStream() {
        return history.keySet().stream();
    }

    /**
     * @return A stream of the entries in the price history
     */
    public Stream<Map.Entry<Long, BigDecimal>> getHistoryStream() {
        return history.entrySet().stream();
    }
}

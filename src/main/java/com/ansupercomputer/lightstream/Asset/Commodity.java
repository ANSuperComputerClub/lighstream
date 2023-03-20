package com.ansupercomputer.lightstream.Asset;

import com.ansupercomputer.lightstream.Exceptions.IllegalOperationException;
import com.ansupercomputer.lightstream.Exceptions.InvalidArgumentException;
import com.ansupercomputer.lightstream.Util.Util;

import java.math.BigDecimal;

/**
 * Defines an asset that is primarily a raw material or agricultural product to be bought and sold.
 * Commodities are dynamically updated via supply and demand TODO: Decide if this is the correct way to approach this
 */
public class Commodity extends Asset {
    /**
     * Defines the relative supply of this commodity, on a scale from 0 to 1.
     * Usually, this will be at 1; it will only dip below when it is being under-produced
     */
    private double supply;

    /**
     * Defines the relative demand of this commodity, on a scale of 0 to 1.
     * Usually, this will also be at 1; it will only dip below when alternatives are cheaper.
     */
    private double demand;

    /**
     * Creates a commodity
     *
     * @param price      The starting price of the Asset
     * @param identifier The identifier of the Asset
     */
    public Commodity(BigDecimal price, String identifier) {
        super(price, identifier);
        supply = 0;
        demand = 0;
    }

    /**
     * Updates the commodity's price using the current supply and demand.
     *
     * @throws IllegalOperationException should an illegal operation occur
     */
    public void updatePrice() throws IllegalOperationException {
        // TODO complicate the supply/demand formula to be more accurate
        double supplyDemandFactor = demand / supply;
        super.updatePrice(Double.compare(supplyDemandFactor, 1) == 0 ? getPrice() : BigDecimal.valueOf(getPrice().doubleValue() * supplyDemandFactor));
    }

    /**
     * Updates the supply factor
     *
     * @param supply the new supply factor
     */
    public void updateSupply(double supply) throws InvalidArgumentException {
        Util.enforceRange(demand, 0, 1);
        this.supply = supply;
    }

    /**
     * Updates the demand factor
     *
     * @param demand the new demand factor
     */
    public void updateDemand(double demand) throws  InvalidArgumentException {
        Util.enforceRange(demand, 0, 1);
        this.demand = demand;
    }

    /**
     * Returns the price of the commodity
     *
     * @return the price of the commodity
     * @throws IllegalOperationException should an illegal operation occur while updating the price
     */
    @Override
    public BigDecimal getPrice() throws IllegalOperationException {
        updatePrice();
        return super.getPrice();
    }
}

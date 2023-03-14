package com.ansupercomputer.lightstream.Asset;

import com.ansupercomputer.lightstream.Exceptions.IllegalOperationException;

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
     * @throws IllegalOperationException should the supply factor be out of the domain (between 0 and 1)
     */
    public void updateSupply(double supply) throws IllegalOperationException {
        if (supply > 1 || supply < 0)
            throw new IllegalOperationException("Cannot set supply factor to be greater than 1 or less than 0");
        this.supply = supply;
    }

    /**
     * Updates the demand factor
     *
     * @param demand the new demand factor
     * @throws IllegalOperationException should the demand factor be out of the domain (between 0 and 1)
     */
    public void updateDemand(double demand) throws IllegalOperationException {
        if (demand > 1 || demand < 0)
            throw new IllegalOperationException("Cannot update demand factor ot be greater than 1 or less than 0");
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

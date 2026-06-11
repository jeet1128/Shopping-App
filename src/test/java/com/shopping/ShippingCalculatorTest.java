package com.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ShippingCalculatorTest{

    @Test
    void standardShippingUnderOrEqualFiftyCostsTen()
    {
        assertEquals(10.0, ShippingCalculator.calculateShipping(ShippingOption.STANDARD, 50.0));
    }

       @Test
    void standardShippingOverFiftyIsFree() {
        assertEquals(0.0, ShippingCalculator.calculateShipping(ShippingOption.STANDARD, 51.0));
    }

    @Test
    void nextDayShippingAlwaysCostsTwentyFive() {
        assertEquals(25.0, ShippingCalculator.calculateShipping(ShippingOption.NEXT_DAY, 100.0));
    }
}
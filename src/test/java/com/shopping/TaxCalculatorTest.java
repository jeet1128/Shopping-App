package com.shopping;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaxCalculatorTest{

    @Test
    void illinoisChargesSixPercentTax()
    {
        assertEquals(6.0, TaxCalculator.calculateTax("IL", 100.0));

    }

    @Test
    void californiaChargesSixPercentTax()
    {
        assertEquals(6.0, TaxCalculator.calculateTax("CA", 100.0));

    }

    @Test
    void newYorkChargesSixPercentTax()
    {
        assertEquals(6.0, TaxCalculator.calculateTax("NY", 100.0));
    }

    @Test
    void otherStateChargesNoTax()
    {
        assertEquals(0.0, TaxCalculator.calculateTax("TX", 100.0));

    }

    @Test
    void lowercaseStateStillChargesTax()
    {
        assertEquals(6.0, TaxCalculator.calculateTax("il", 100.0));
    }

    @Test
    void taxCalculatorCanBeCreated()
{
    TaxCalculator calculator = new TaxCalculator();
    assertTrue(calculator !=null);
}
}
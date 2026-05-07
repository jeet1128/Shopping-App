package com.shopping;

public class ShippingCalculator {
    public static double calculateShipping(ShippingOption option, double subtotal) {
        if (option == ShippingOption.STANDARD) {
            return subtotal > 50 ? 0.0 : 10.0;
        }
        return 25.0;
    }
}
package com.shopping;

import java.util.*;

public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(String name, double price, int quantity) {
        items.add(new CartItem(name, price, quantity));
        System.out.println("Item added. Total items: " + getItemCount());
    }

    public int getItemCount() {
        return items.stream().mapToInt(CartItem::getQuantity).sum();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            CartItem i1 = items.get(i);
            System.out.println((i+1)+". "+i1.getItemName()+" | Qty: "+i1.getQuantity()+" | $"+i1.getTotalPrice());
        }
    }

    public void editQuantity(int index, int qty) {
        items.get(index-1).setQuantity(qty);
    }

    public void removeItem(int index) {
        items.remove(index-1);
    }

    public double getTotal(String state, ShippingOption option) {
        double sub = getSubtotal();
        return sub + TaxCalculator.calculateTax(state, sub) +
                ShippingCalculator.calculateShipping(option, sub);
    }
}
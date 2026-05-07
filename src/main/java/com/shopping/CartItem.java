package com.shopping;

public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        if (quantity < 1) throw new IllegalArgumentException("Quantity must be at least 1.");
        if (price < 1 || price > 99999.99) throw new IllegalArgumentException("Invalid price.");

        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        if (quantity < 1) throw new IllegalArgumentException("Quantity must be at least 1.");
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}
package com.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ShoppingCartTest{

    @Test
    void newCarHasZeroItemsAndZeroSubtotal()
    {
        ShoppingCart cart = new ShoppingCart();

        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getSubtotal());

    }

    @Test
    void addItemIncreasesItemCountAndSubtotal()
    {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 10.0, 2);

        assertEquals(2, cart.getItemCount());
        assertEquals(20.0, cart.getSubtotal());
    }

    @Test
    void addMultipleItemsCalculatesSubtotalCorrectly()
    {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Book", 10.0, 2);
        cart.addItem("Pen", 2.0, 5);

        assertEquals(7, cart.getItemCount());
        assertEquals(30.0, cart.getSubtotal());

    }

    @Test
    void editQuantityUpdatesItemCountAndSubtotal()
    {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Book", 10.0, 2);
        cart.editQuantity(1,5);

        assertEquals(5, cart.getItemCount());
        assertEquals(50.0, cart.getSubtotal());
    }

    @Test
void removeItemUpdatesCart()
{
    ShoppingCart cart = new ShoppingCart();

    cart.addItem("Book", 10.0, 2);
    cart.addItem("Pen", 2.0, 5);

    cart.removeItem(1);

    assertEquals(5, cart.getItemCount());
    assertEquals(10.0, cart.getSubtotal());
}

@Test
void totalIncludesIllinoisTaxAndStandardShipping()
{
    ShoppingCart cart = new ShoppingCart();

    cart.addItem("Book", 10.0, 2);
    assertEquals(31.20, cart.getTotal("IL", ShippingOption.STANDARD), 0.01);
}

@Test
void totalIncludesFreeStandardShippingOverFifty()
{
    ShoppingCart cart = new ShoppingCart();
    cart.addItem("Shoes", 60.0, 1);

    assertEquals(63.60, cart.getTotal("IL", ShippingOption.STANDARD), 0.01);
}

@Test
void totalIncludesNextDayShipping()
{
    ShoppingCart cart = new ShoppingCart();

    cart.addItem("Book", 10.0, 2);
    assertEquals(46.20, cart.getTotal("IL", ShippingOption.NEXT_DAY), 0.01);
}

@Test
void viewEmptyCartPrintsEmptyMessage()
{
    

    java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
    //System.setOut(new java.io.PrintStream(output));

    ShoppingCart cart = new ShoppingCart(new java.io.PrintStream(output));

    cart.viewCart();

    assertTrue(output.toString().contains("Cart is empty."));
}

@Test
void viewCartPrintsItemDetails()
{
    

    java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
   // System.setOut(new java.io.PrintStream(output));

   ShoppingCart cart = new ShoppingCart(new java.io.PrintStream(output));
    cart.addItem("Book", 10.0, 2);

    cart.viewCart();

    assertTrue(output.toString().contains("Book"));
    assertTrue(output.toString().contains("Qty: 2"));
    assertTrue(output.toString().contains("$20.0"));


}
@Test
void editQuantityWithInvalidItemNumberThrowsError()

{
ShoppingCart cart = new ShoppingCart();
cart.addItem("Book", 10.0, 1);

assertThrows(IndexOutOfBoundsException.class, ()->
{
    cart.editQuantity(5, 2);
});
}

@Test
void removeItemWithInvalidItemNumberThrowsError()
{
    ShoppingCart cart = new ShoppingCart();
    cart.addItem("Book", 10.0, 1);

    assertThrows(IndexOutOfBoundsException.class, ()->
{
    cart.removeItem(5);
});
}

@Test
void addItemPrintsConfirmationMessage()
{
   
    java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
    //System.setOut(new java.io.PrintStream(output));
 ShoppingCart cart = new ShoppingCart(new java.io.PrintStream(output));


    cart.addItem("Book", 10.0, 2);

    assertTrue(output.toString().contains("Item added. Total items: 2"));
}

@Test
void viewCartPrintsCorrectItemNumber()
{
    


    java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
    //System.setOut(new java.io.PrintStream(output));
    ShoppingCart cart = new ShoppingCart(new java.io.PrintStream(output));
    
    cart.addItem("Book", 10.0, 2);

    cart.viewCart();
    assertTrue(output.toString().contains("1. Book"));
}
@Test
void viewCartShowsCorrectNumberForSecondItem()
{
    java.io.ByteArrayOutputStream output =
            new java.io.ByteArrayOutputStream();

    ShoppingCart cart =
            new ShoppingCart(new java.io.PrintStream(output));

    cart.addItem("Book", 10.0, 1);
    cart.addItem("Pen", 2.0, 1);

    cart.viewCart();

    String text = output.toString();

    assertTrue(text.contains("1. Book"));
    assertTrue(text.contains("2. Pen"));
}
}
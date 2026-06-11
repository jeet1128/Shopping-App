package com.shopping;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class CartItemTest
{
    @Test
    void validCartItemCreatesSuccessfully()
    {
        CartItem item = new CartItem("Book", 10.0, 2);

        assertEquals("Book", item.getItemName());
        assertEquals(10.0, item.getPrice());
        assertEquals(2, item.getQuantity());
        assertEquals(20.0, item.getTotalPrice());
    }

    @Test
    void quantityLessThanOneThrowsError()
    {
        assertThrows(IllegalArgumentException.class, ()->
    {
        new CartItem("Book",10.0,0);
    });
    }

    @Test 
    void priceLessThanOneThrowsError()
{
    assertThrows(IllegalArgumentException.class, ()-> {
        new CartItem("Book", 0.99, 1);
    });
}

@Test
void priceGreaterThanMaximumThrowsError()
{
    assertThrows(IllegalArgumentException.class, () -> {
        new CartItem("car", 100000.00, 1);
    });
}

@Test
void setValidQuantityUpdatesQuantity()
{
    CartItem item = new CartItem("Book", 10.0, 1);

    item.setQuantity(5);
    assertEquals(5, item.getQuantity());
}

@Test
void setInvalidQuantityThrowsError()
{
    CartItem item = new CartItem("Book", 10.0, 1);

    assertThrows(IllegalArgumentException.class, ()-> {
        item.setQuantity(0);
    });
}

}
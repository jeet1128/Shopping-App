error id: file:///C:/Users/makwa/OneDrive/Documents/Visual%20Studio%202012/shopping-app/src/test/java/com/shopping/CartItemTest.java:_empty_/CartItem#setQauntity#
file:///C:/Users/makwa/OneDrive/Documents/Visual%20Studio%202012/shopping-app/src/test/java/com/shopping/CartItemTest.java
empty definition using pc, found symbol in pc: _empty_/CartItem#setQauntity#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1280
uri: file:///C:/Users/makwa/OneDrive/Documents/Visual%20Studio%202012/shopping-app/src/test/java/com/shopping/CartItemTest.java
text:
```scala
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
        item.setQaunt@@ity(0);
    });
}

}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/CartItem#setQauntity#
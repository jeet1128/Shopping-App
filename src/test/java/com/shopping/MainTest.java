package com.shopping;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;

class MainTest{
    @Test
    void checkoutFlowRunsWithoutException()
    {
        String input =
        "John\n" +
                "IL\n" +
                "1\n" +
                "6\n";

                System.setIn(new ByteArrayInputStream(input.getBytes()));
                assertDoesNotThrow(()->Main.main(new String[]{}));
    }

    @Test

    void addItemViewTotalAndCheckoutFlowRunsWithoutException()
    {
        String input = 
        "John\n" +
                "IL\n" +
                "1\n" +
                "1\n" +
                "Book\n" +
                "10\n" +
                "2\n" +
                "2\n" +
                "6\n";

                System.setIn(new ByteArrayInputStream(input.getBytes()));

                assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
    @Test
    void nextDayShippingFlowRunsWithoutException()
    {
        String input =
        "John\n" +
        "CA\n" +
        "2\n" +
        "1\n" +
        "Shoes\n" +
    "60\n" +
    "1\n" +
    "2\n" +
    "6\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    assertDoesNotThrow(() -> Main.main(new String[]{}));
    }

    @Test
    void viewEditRemoveAndCheckoutFlowRunsWithoutException()
    {
        String input =
        "John\n" +
        "NY\n" +
        "1\n" +
        "1\n" +
        "Pen\n" +
        "5\n" +
        "3\n" +
         "3\n" +
         "4\n" +
            "1\n" +
            "5\n" +
            "5\n" +
            "1\n" +
             "6\n";

             System.setIn(new ByteArrayInputStream(input.getBytes()));

             assertDoesNotThrow(() -> Main.main(new String[]{}));
    }

    @Test
    void standardShippingFlowWorks()
    {
        String input =
        "John\n" +
        "IL\n" +
        "1\n" +
        "6\n";

        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{});

    }

    @Test
    void nextDayShippingFlowWorks()
    {
        String input = 
        "John\n" +
        "IL\n" +
        "2\n" +
        "6\n";

        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{});
    }
}
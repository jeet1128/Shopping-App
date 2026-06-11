package com.shopping;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ShoppingCLITest {

    @Test
    void fullStandardShippingUserFlowPrintsExpectedOutput() {
        String input =
                "John\n" +
                "IL\n" +
                "1\n" +
                "1\n" +
                "Book\n" +
                "10\n" +
                "2\n" +
                "2\n" +
                "3\n" +
                "6\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        ShoppingCLI cli = new ShoppingCLI(
                new ByteArrayInputStream(input.getBytes()),
                new PrintStream(output)
        );

        cli.run();

        String result = output.toString();

        assertTrue(result.contains("Enter Name:"));
        assertTrue(result.contains("Enter State:"));
        assertTrue(result.contains("Choose Shipping Option"));
        assertTrue(result.contains("1. Standard"));
        assertTrue(result.contains("2. Next_Day"));
        assertTrue(result.contains("Enter choice:"));
        assertTrue(result.contains("1.Add 2.Total 3.View 4.Edit 5.Remove 6.Checkout"));
        assertTrue(result.contains("Item:"));
        assertTrue(result.contains("Price:"));
        assertTrue(result.contains("Qty:"));
        assertTrue(result.contains("Item added. Total items: 2"));
        assertTrue(result.contains("Total: 31.2"));
        assertTrue(result.contains("1. Book"));
        assertTrue(result.contains("Transaction completed"));
    }

    @Test
    void editAndRemoveFlowPrintsExpectedOutput() {
        String input =
                "John\n" +
                "NY\n" +
                "1\n" +
                "1\n" +
                "Pen\n" +
                "5\n" +
                "3\n" +
                "4\n" +
                "1\n" +
                "5\n" +
                "3\n" +
                "5\n" +
                "1\n" +
                "3\n" +
                "6\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        ShoppingCLI cli = new ShoppingCLI(
                new ByteArrayInputStream(input.getBytes()),
                new PrintStream(output)
        );

        cli.run();

        String result = output.toString();

        assertTrue(result.contains("Item no:"));
        assertTrue(result.contains("New qty:"));
        assertTrue(result.contains("1. Pen | Qty: 5 | $25.0"));
        assertTrue(result.contains("Cart is empty."));
        assertTrue(result.contains("Transaction completed"));
    }

    @Test
    void invalidMenuOptionPrintsInvalidOption() {
        String input =
                "John\n" +
                "TX\n" +
                "1\n" +
                "99\n" +
                "6\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        ShoppingCLI cli = new ShoppingCLI(
                new ByteArrayInputStream(input.getBytes()),
                new PrintStream(output)
        );

        cli.run();

        String result = output.toString();

        assertTrue(result.contains("Invalid option"));
        assertTrue(result.contains("Transaction completed"));
    }

    @Test
    void nextDayShippingFlowPrintsCorrectTotal() {
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

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        ShoppingCLI cli = new ShoppingCLI(
                new ByteArrayInputStream(input.getBytes()),
                new PrintStream(output)
        );

        cli.run();

        String result = output.toString();

        assertTrue(result.contains("Total: 88.6"));
        assertTrue(result.contains("Transaction completed"));
    }
    @Test
    void editMenuShowsItemNumberPrompt()
    {
        String input = 
        "John\n" +
            "IL\n" +
            "1\n" +
            "4\n" +
            "1\n" +
            "5\n" +
            "6\n";
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            ShoppingCLI cli = new ShoppingCLI(
                new ByteArrayInputStream(input.getBytes()),
                new PrintStream(output));
            assertThrows(Exception.class, cli::run);
            assertTrue(output.toString().contains("Item no:"));
    }

    @Test
    void removeMenuShowsItemNumberPrompt()
    {
        String input = "John\n" +
            "IL\n" +
            "1\n" +
            "5\n" +
            "1\n" +
            "6\n";
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            ShoppingCLI cli = new ShoppingCLI(
                new ByteArrayInputStream(input.getBytes()),
                new PrintStream(output)
            );

            assertThrows(Exception.class, cli::run);
            assertTrue(output.toString().contains("Item no:"));
    }
    @Test
void addItemShowsQuantityPrompt()
{
    String input =
            "John\n" +
            "IL\n" +
            "1\n" +
            "1\n" +
            "Book\n" +
            "10\n" +
            "2\n" +
            "6\n";

    java.io.ByteArrayOutputStream output =
            new java.io.ByteArrayOutputStream();

    ShoppingCLI cli =
            new ShoppingCLI(
                    new java.io.ByteArrayInputStream(input.getBytes()),
                    new java.io.PrintStream(output));

    cli.run();

    assertTrue(output.toString().contains("Qty:"));
}

}
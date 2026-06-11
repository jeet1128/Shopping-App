package com.shopping;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ShoppingCLI
{
    private final Scanner sc;
    private final PrintStream out;
    private final ShoppingCart cart;

    public ShoppingCLI(InputStream input, PrintStream output)
    {
        this.sc = new Scanner(input);
        this.out = output;
        this.cart = new ShoppingCart(output);
    }

    public void run()
    {
        out.print("Enter Name:");
        String name = sc.nextLine();

        out.print("Enter State:");
        String state = sc.nextLine();
        
         out.println("Choose Shipping Option");
        out.println("1. Standard");
        out.println("2. Next_Day");
        out.println("Enter choice:");

        int shippingChoice = sc.nextInt();

        ShippingOption option;

        if (shippingChoice == 1) {
            option = ShippingOption.STANDARD;
        } else {
            option = ShippingOption.NEXT_DAY;
        }

        while (true) {
            out.println("\n1.Add 2.Total 3.View 4.Edit 5.Remove 6.Checkout");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    sc.nextLine();
                    out.print("Item: ");
                    String item = sc.nextLine();

                    out.print("Price: ");
                    double p = sc.nextDouble();

                    out.print("Qty: ");
                    int q = sc.nextInt();

                    cart.addItem(item, p, q);
                    break;

                case 2:
                    out.println("Total: " + cart.getTotal(state, option));
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    out.print("Item no: ");
                    int i = sc.nextInt();

                    out.print("New qty: ");
                    int nq = sc.nextInt();

                    cart.editQuantity(i, nq);
                    break;

                case 5:
                    out.print("Item no: ");
                    cart.removeItem(sc.nextInt());
                    break;

                case 6:
                    out.println("Transaction completed");
                    return;

                default:
                    out.println("Invalid option");
                    break;
            }
        }
    }
}
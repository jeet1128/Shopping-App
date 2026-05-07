package com.shopping;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter State: ");
        String state = sc.nextLine();

       
       System.out.println("Choose Shipping Option");
       System.out.println("1. Standard");
        System.out.println("2. Next_Day");
        System.out.println("Enter choice:");

        int shippingChoice = sc.nextInt();

        ShippingOption option;

        if(shippingChoice == 1)
        {
            option = ShippingOption.STANDARD;
        
        }
           else{
            option = ShippingOption.NEXT_DAY;
           }

        while (true) {
            System.out.println("\n1.Add 2.Total 3.View 4.Edit 5.Remove 6.Checkout");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    sc.nextLine();
                    System.out.print("Item: ");
                    String item = sc.nextLine();
                    System.out.print("Price: ");
                    double p = sc.nextDouble();
                    System.out.print("Qty: ");
                    int q = sc.nextInt();
                    cart.addItem(item,p,q);
                    break;

                case 2:
                    System.out.println("Total: "+cart.getTotal(state, option));
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    System.out.print("Item no: ");
                    int i = sc.nextInt();
                    System.out.print("New qty: ");
                    int nq = sc.nextInt();
                    cart.editQuantity(i,nq);
                    break;

                case 5:
                    System.out.print("Item no: ");
                    cart.removeItem(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Transaction completed");
                    return;
            }
        }
    }
}
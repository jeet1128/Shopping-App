package com.shopping;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       ShoppingCLI cli = new ShoppingCLI(System.in, System.out);
       cli.run();
    }
}

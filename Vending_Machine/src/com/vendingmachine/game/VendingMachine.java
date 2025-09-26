package com.vendingmachine.game;

import java.util.*;

public class VendingMachine {
	Scanner sc = new Scanner(System.in);
	
	public void start() {
		System.out.println("========== Welcome to the vending machine ===========");
		System.out.println("Select you Drink: ");
		System.out.println("1. Tea");
		System.out.println("2. Coffee");
		System.out.println("3. Juice");
		
		int choice = sc.nextInt();
		
		Product product = null;
		
		if(choice == 1) {
			product = new Tea();
		} else if(choice == 2) {
			product = new Coffee();
		} else if(choice == 3) {
			product = new Juice();
		} else {
			System.out.println("Wrong Choice! Kindly choose the correct one.");
            return;
		}
		
		System.out.println("You selected: " + product.getClass().getSimpleName());
		System.out.println("Price: " + product.price());
		
		product.drink();
	}
}

package com.vendingmachine.game;

public class Juice implements Product {
	@Override
	public double price() {
		return 40;
	}
	
	@Override
	public void drink() {
		System.out.println("Enjoy your refreshing Juice");
	}
}

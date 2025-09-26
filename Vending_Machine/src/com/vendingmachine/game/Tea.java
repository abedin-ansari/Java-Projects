package com.vendingmachine.game;

public class Tea implements Product {
	@Override
	public double price() {
		return 10;
	}
	
	@Override
	public void drink() {
		System.out.println("Enjoy you hot cup of Tea");
	}
}

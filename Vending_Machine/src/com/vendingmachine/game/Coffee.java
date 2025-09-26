package com.vendingmachine.game;

public class Coffee implements Product {
	@Override
	public double price() {
		return 20;
	}
	
	@Override
	public void drink() {
		System.out.println("Enjoy your hot cup of Coffee");
	}
}

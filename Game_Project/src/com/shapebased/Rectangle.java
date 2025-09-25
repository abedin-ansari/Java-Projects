package com.shapebased;

public class Rectangle implements TwoDShape {
	double l, w;
	Rectangle(double l, double w){
		this.l = l;
		this.w = w;
	}
	
	@Override
	public void area() {
		double area = l*w;
		System.out.println("Area is: " + area);
	}
	
	@Override
	public void perimeter() {
		double perimeter = 2*(l+w);
		System.out.println("Perimeter is: " + perimeter);
	}
}

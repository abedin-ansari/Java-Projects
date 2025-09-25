package com.shapebased;

public class Cylinder implements ThreeDShape {
	double r,h;
	Cylinder(double r, double h){
		this.r = r;
		this.h = h;
	}
	
	@Override
	public void volume() {
		double vol = Math.PI*r*r*h;
		System.out.println("Volume is: " + vol);
	}
	
	@Override
	public void lsa() {
		double lsa = 2*Math.PI*r*h;
		System.out.println("Lateral Surface Area (LSA) is: " + lsa);
	}
	
	@Override
	public void tsa() {
		double tsa = 2*Math.PI*r*(h+r);
		System.out.println("Total surface area is: " + tsa);
	}
}

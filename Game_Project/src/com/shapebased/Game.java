package com.shapebased;

import java.util.*;

public class Game {
	Scanner sc = new Scanner(System.in);
	{
		System.out.println("============ Game Has been started =============");
	}
	
	public void selectShape() {
		System.out.println("Press 1 for ==> 2D Shape");
		System.out.println("Press 2 for ==> 3D Shape");
		
		int choice = sc.nextInt();
		if(choice == 1) {
			System.out.println("You have selected 2D Shape");
			
			TwoDShape shape2D = selectTwoDShape();
			shape2D.area();
			shape2D.perimeter();
			
		} else if(choice == 2) {
			System.out.println("You have selected 3D Shape");
			
			ThreeDShape shape3D = selectThreeDShape();
			shape3D.volume();
			shape3D.lsa();
			shape3D.tsa();
			
		} else {
			System.out.println("You have entered Invalid choice");
			selectShape();
		}
	}
	
	public TwoDShape selectTwoDShape(){
		System.out.println("Press 1 for ==> Circle");
		System.out.println("Press 2 for ==> Rectangle");
		
		int choice = sc.nextInt();
		if(choice == 1) {
			System.out.println("You have selected circle");
			
			System.out.println("Now Enter the radius: ");
			double r = sc.nextDouble();
			return new Circle(r);
		} else if(choice == 2) {
			System.out.println("You have selected rectangle");
			
			System.out.println("Enter the Length: ");
			double l = sc.nextDouble();
			System.out.println("Enter the Width: ");
			double w = sc.nextDouble();
			
			return new Rectangle(l, w);
		} else {
			System.out.println("You have entered Invalid choice\n");
			return selectTwoDShape();
		}
	}
	
	public ThreeDShape selectThreeDShape() {
		System.out.println("Press 1 for ==> Cylinder");
		
		int choice = sc.nextInt();
		if(choice == 1) {
			System.out.println("You have selected Cylinder");
			
			System.out.println("Enter the radius: ");
			double r = sc.nextDouble();
			System.out.println("Enter the Height: ");
			double h = sc.nextDouble();
			
			return new Cylinder(r, h);
		} else {
			System.out.println("You have entered Invalid Choice\n");
			return selectThreeDShape();
		}
	}
}

package com.javaArray.project;

class Service{

	public void printAllEmployees(Employ[] employees){
		for(Employ e:employees)
			System.out.println(e);
	}

	public void printEmployeesWithAge(Employ[] employees){
		int count=0;
		for(Employ e:employees){
			if(e.age>=30){
				System.out.println(e);
				count++;
			}
		}
		System.out.println("Total Such Employees are: "+count);
	}
	public static void printEmployWithHighestAndLeastSalary(Employ[] employees){
		Employ big=employees[0];	Employ small=employees[0];
		for(Employ e:employees){
			if(e.salary>big.salary)
				big=e;
			else if(e.salary<small.salary)
				small=e;
		}
		System.out.println("Max Salary Employ Details: "+big);
		System.out.println("Min Salary Employ Details: "+small);

	}
}

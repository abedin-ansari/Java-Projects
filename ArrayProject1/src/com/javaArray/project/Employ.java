package com.javaArray.project;

class Employ{
	String name;
	int id;
	int age;
	double salary;
	Employ(){
	}
	Employ(String name, int id, int age, double salary){
		this.name=name;
		this.id=id;
		this.age=age;
		this.salary=salary;
	}
	public String toString(){
	return "Name: "+name+"\tId: "+id+"\tAge: "+age+"\tSalary: "+salary; 
	}
}
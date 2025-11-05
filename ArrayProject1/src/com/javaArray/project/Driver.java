package com.javaArray.project;

class Driver{
	public static void main(String[] args){
		Employ e1=new Employ("Mohan", 123, 23, 12345.6);
		Employ e2=new Employ("Rohan", 103, 23, 19345.6);
		Employ e3=new Employ("Sohan", 193, 21, 57345.6);
		Employ e4=new Employ("John", 183, 28, 12745.6);
		Employ e5=new Employ("Jack", 173, 25, 18345.6);
		Employ e6=new Employ("HMohan", 153, 27, 22345.6);
		Employ e7=new Employ("Nitin", 143, 33, 10345.6);
		Employ e8=new Employ("Raj", 323, 43, 28345.6);
		Employ e9=new Employ("Raju", 223, 22, 32345.6);
		Employ e10=new Employ("Heera", 122, 27, 36345.6);

		//Employ[] employees=new Employ[10];
		//employees[0]=e1;
		//employees[1]=e2;
		Employ[] employees={e1, e2, e3, e4, e5, e6, e7, e8, e9, e10};
		
		/*for(int i=0;i<employees.length;i++)
			System.out.println(employees[i]);
		System.out.println("======================");	
		for(Employ e:employees)
			System.out.println(e);*/

		Service service=new Service();
		System.out.println("========Q1===============");
		service.printAllEmployees(employees);
		System.out.println("========Q2===============");
		service.printEmployeesWithAge(employees);
		System.out.println("========Q3===============");
		service.printEmployWithHighestAndLeastSalary(employees);

	}
	
}

// public class Driver {
//     public static void main(String[] args) {
//         Employ e1 = new Employ("Mohan", 123, 23, 1234.2);
//         Employ e2 = new Employ("Rohan", 103, 23, 4757.4);
//         Employ e3 = new Employ("Sohan", 838, 24, 4893.3);
//         Employ e4 = new Employ("John", 444, 43, 1234.7);
//         Employ e5 = new Employ("Jack", 222, 33, 2678.9);
//         Employ e6 = new Employ("harry", 898, 29, 9876.4);
//         Employ e7 = new Employ("Snow", 784, 23, 4873.9);
//         Employ e8 = new Employ("Nitin", 432, 23, 2674.2);
//         Employ e9 = new Employ("Raj", 284, 23, 1234.3);
//         Employ e10 = new Employ("Aj", 800, 23, 9872.7);

//         // Employ[] employees = new Employ[10];
//         // employees[0] = e1

//         Employ[] employees  = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10};
//         // for(int i = 0; i < employees.length; i++){
//         //     System.out.println(employees[i]);
//         // }
//         // System.out.println("======================");
//         // for(Employ e: employees){
//         //     System.out.println(e);
//         // }

//         printAllEmployees(employees);
        
//     }
// }

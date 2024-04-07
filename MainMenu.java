package com.jspiders.cardekhohibernate.dao;

import java.util.Scanner;




public class MainMenu {
	
	public static void main(String [] args) {
		 boolean flag=true;
		 while(flag) {
			 System.out.println("=====MAIN MENU======\n"
						+"1. Enter 1 to Add Car\n"
					 	+"2. Enter 2 to search cars\n"
						+"6. Enter 6 to View All cars\n"
						+"7. Enter 7 to delete car\n"
						+"8. Enter 8 to update car\n"
						+"9. Enter 9 to Exit");
			 Scanner scanner = new Scanner(System.in);
			 System.out.println("Enter your choice here...");
			 int choice = scanner.nextInt();
			 
			 switch(choice) {
			 
			 case 1:
				 CarOperations.addCar();
				 break;
			 
			 case 2:
				 CarOperations.searchCar();
			 break;
//			 case 3:
//				 CarDekhoOperation.searchCarByPrice();
//			break;
//			 case 4:
//				 CarDekhoOperation.searchCarByBrand();
//				 break;
//			 case 5:
//				 CarDekhoOperation.searchCarByColor();
//				 break;
			 case 6:
				 CarOperations.viewAll();
				 break;
			 case 7:
				 CarOperations.delete();
				 break;
			 case 8:
				 CarOperations.updateCar();
				 break;
			 case 9:
				 System.out.println("Thank you...visit again");
//				 flag =false;
//				 break;
			 }
//			 
			 
		 }
	}
	
	
	} 
		



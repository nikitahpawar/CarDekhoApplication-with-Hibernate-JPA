package com.jspiders.cardekhohibernate.dao;


import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.cardekhohibernate.dto.CarDTO;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;



public class CarOperations {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("cars");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	
	private static void closeConnection()
	{
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
			
		}
		if(entityManager!=null) {
			entityManager.close();
		}
		if(entityTransaction!=null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	//Add
	public static void addCar() {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter car id");
		int id=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("enter car name");
		String name=scanner.nextLine();
		
		System.out.println("enter car brand");
		String brand=scanner.nextLine();
		
		System.out.println("enter car fueltype");
		String fueltype=scanner.nextLine();
		
		System.out.println("enter car price");
		int price=scanner.nextInt();
		
		openConnection();
		
		entityTransaction.begin();
		
		CarDTO car=new CarDTO();
		car.setCarId(id);
		car.setName(name);
		car.setBrand(brand);
		car.setFuelType(fueltype);
		car.setPrice(price);
		entityManager.persist(car);
		
		entityTransaction.commit();
		closeConnection();
		
	}
	//Delete
	public static void delete() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter car id which you want to delete");
		int id=scanner.nextInt();
		
		openConnection();
		entityTransaction.begin();
		CarDTO car=entityManager.find(CarDTO.class, id);
		entityManager.remove(car);
		
		entityTransaction.commit();
		closeConnection();
		
		
	}
	//viewAll
	public static void viewAll() {
		
		
		openConnection();
		entityTransaction.begin();
		List<CarDTO> cars=FindAll();
		
		for(CarDTO car: cars) {
			System.out.println(car);
		}
		
		
		entityTransaction.commit();
		closeConnection();
		
		
	}
	public static List<CarDTO> FindAll() {
		Query query= entityManager.createQuery("select car from CarDTO car");
		List<CarDTO> cars=query.getResultList();
		return cars;
	}
	
	public static void updateCar() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter car id which you want to update");
		int id=scanner.nextInt();
		
		System.out.println("Enter New price");
		int price=scanner.nextInt();
		
		
		openConnection();
		entityTransaction.begin();
		
		CarDTO car= entityManager.find(CarDTO.class, id);
		car.setPrice(price);
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	
	//1
	public static void id() {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter car id");
		int id=scanner.nextInt();
		
		openConnection();
		entityTransaction.begin();
		
		CarDTO car=entityManager.find(CarDTO.class, id);
		System.out.println(car);

		
		
		entityTransaction.commit();
		closeConnection();
		
	}
	//2
	public static void price() {
	
		
		openConnection();
		entityTransaction.begin();
		
		
		List<CarDTO> cars=findAll();
		
		for(CarDTO car : cars) {
			System.out.println(car);
			
		}
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	public static List<CarDTO> findAll() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter car price");
		int price=scanner.nextInt();
		
		Query query= entityManager.createQuery("select car from CarDTO car WHERE price = ?1");
		query.setParameter(1, price);
		List<CarDTO> cars=query.getResultList();
		return cars;
	}
	
//3
public static void name() {
	
		
		openConnection();
		entityTransaction.begin();
		
		
		List<CarDTO> cars=findName();
		
		for(CarDTO car : cars) {
			System.out.println(car);
			
		}
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	public static List<CarDTO> findName() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter car name");
		String name=scanner.nextLine();
		
		Query query= entityManager.createQuery("select car from CarDTO car WHERE name = ?1");
		query.setParameter(1, name);
		List<CarDTO> cars=query.getResultList();
		return cars;
	}
		
	
//4
public static void color() {
	
		
		openConnection();
		entityTransaction.begin();
		
		
		List<CarDTO> cars=findAll();
		
		for(CarDTO car : cars) {
			System.out.println(car);
			
		}
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	public static List findColor() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter car color");
		String color=scanner.nextLine();
		
		Query query= entityManager.createQuery("select car from CarDTO car WHERE color = ?1");
		query.setParameter(1, color);
		List cars=query.getResultList();
		return cars;
	}
		
	
	
	
	
	public static void searchCar() {
		boolean flag=true;
		 while(flag) {
			 System.out.println("1. Enter 1 to search a car by id\n"
					 	+"2. Enter 2 to search a car by price\n"
						+"3. Enter 3 to search a car by name\n"
						+"4. Enter 4 to search car by color \n"
						+"5. Enter 5 to search car by brand\n"
						+"9. Enter 9 to Exit");
			 Scanner scanner = new Scanner(System.in);
			 System.out.println("Enter your choice here...");
			 int choice = scanner.nextInt();
			 
			 switch(choice) {
			 
			 case 1:
				id();
				break;
			 
			 case 2:
				 price();
				 break;
				 
			 case 3:
				 name();
				 break;
				
			 case 4:
				 color();
				 break;
				 
//			 case 7:
//				 CarOperations.delete();
//				 break;
//			 case 8:
//				 CarOperations.updateCar();
//				 break;
//			 case 9:
//				 System.out.println("Thank you...visit again");
//				 flag =false;
//				 break;
			 }
//			 
			 
		 }
	}
	
}// class block







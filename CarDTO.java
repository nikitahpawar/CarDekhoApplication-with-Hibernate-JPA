package com.jspiders.cardekhohibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name = "car_info")
public class CarDTO {
	
		
		@Id
		private int CarId;
		
		@Column(nullable = false)
		private String name;
		
		@Column(nullable = false)
		private String brand;
		
		@Column(nullable = false)
		private String fuelType;
		
		@Column(nullable = false)
		private int price;


}

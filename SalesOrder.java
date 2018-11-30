
package com.example.demo.salesOrder;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="SalesOrderDetails")
@EntityListeners(AuditingEntityListener.class)
public class SalesOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String quality;
	@NotBlank
	private Long quantity;
	@NotBlank
	private double price;


	public SalesOrder() {

	}

	public SalesOrder(String name) {
		this.setName(name);
		this.setName(quality);
	}
	public SalesOrder(Long quantity) {
		this.setQuantity(quantity);
	}
	
	public SalesOrder(double price) {
		this.setPrice(price);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
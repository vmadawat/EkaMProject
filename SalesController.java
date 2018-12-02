package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.salesOrder.SalesOrder;
import com.example.demo.salesOrderDao.SalesOrderDao;



@RestController
@RequestMapping("/company")
public class SalesController{
	
	@Autowired
	SalesOrderDao salesOrderDao;
	
	/* to save a salesOrder*/
	@PostMapping
	public SalesOrder createSalesOrder(@Valid @RequestBody SalesOrder sales) 
	{
		return salesOrderDao.save(sales);
	}
	
	/*get all salesOrder*/
	
	@GetMapping("/salesOrders")
	public List<SalesOrder> getAllSales(){
		return salesOrderDao.findAll();
	}
	
	
	/*get all salesOrder by id*/
	
	@GetMapping("/salesOrder/{id}")
	public ResponseEntity<SalesOrder> getSalesOrderById(
			@PathVariable(value="id") Long salesid)
	{
		SalesOrder salesOrder = findValueOfSalesOrder(salesid);
		if(salesOrder==null) 
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(salesOrder);
	}
	
	/*update an salesOrder by salesid*/
	@PutMapping("/salesOrder/{id}")
	public ResponseEntity<SalesOrder> updateSalesOrder(
			@PathVariable(value="id") Long salesid,
			@Valid @RequestBody SalesOrder salesDetails)
	{
		SalesOrder salesOrder=findValueOfSalesOrder(salesid);
		if(salesOrder==null) 
		{
			return ResponseEntity.notFound().build();
		}
		salesOrder.setName(salesDetails.getName());
		salesOrder.setPrice(salesDetails.getPrice());
		salesDetails.setQuality(salesDetails.getQuality());
		salesDetails.setQuantity(salesDetails.getQuantity());
		
		SalesOrder updateSalesOrder=salesOrderDao.save(salesOrder);
		return ResponseEntity.ok().body(updateSalesOrder);
	}
	
	/*Delete a salesOrder*/
	
	@DeleteMapping("/salesOrder/{id}")
	public ResponseEntity<SalesOrder> updateSalesOrder(@PathVariable(value="id") Long salesid){
		SalesOrder salesOrder = findValueOfSalesOrder(salesid);
		if(salesOrder==null) 
		{
			return ResponseEntity.notFound().build();
		}
		salesOrderDao.delete(salesOrder);
		return ResponseEntity.ok().build();
	}

	private SalesOrder findValueOfSalesOrder(Long salesid) {
		Optional<SalesOrder> salesOrder=salesOrderDao.getOne(salesid);
		return salesOrder.get();
	}
	
}

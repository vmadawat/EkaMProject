
package com.example.demo.salesOrderDao;

import java.util.List;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.SalesRepository;
import com.example.demo.salesOrder.SalesOrder;


@Service
public class SalesOrderDao{
	@Autowired
	SalesRepository salesRepository;
	/*to save a salesOrder*/
	public SalesOrder save(SalesOrder sales) {
	  	
	  return salesRepository.save(sales);
	}	
	/*to search all salesOrder*/
	
	public List<SalesOrder> findAll(){
		return salesRepository.findAll();
	}	
	/*get a salesOrder by id*/
	
    public SalesOrder findOne(Long salesid){
    	return salesRepository.findOne(salesid);
    }
	
	/*delete a salesOrder */
    
    public void delete(SalesOrder sales) {
    	
    	 salesRepository.delete(sales);
    }
}
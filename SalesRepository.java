
package com.example.demo.repository;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.salesOrder.SalesOrder;

import org.springframework.data.jpa.repository.JpaRepository;

@RestController
public interface SalesRepository extends JpaRepository<SalesOrder, Long> {

	SalesOrder findOne(Long salesid);

}


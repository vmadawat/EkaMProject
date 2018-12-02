
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.salesOrder.SalesOrder;

public interface SalesRepository extends JpaRepository<SalesOrder, Long> {

}


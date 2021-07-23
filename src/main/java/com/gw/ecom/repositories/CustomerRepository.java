package com.gw.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gw.ecom.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
}

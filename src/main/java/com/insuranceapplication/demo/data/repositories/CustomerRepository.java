package com.insuranceapplication.demo.data.repositories;

import com.insuranceapplication.demo.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

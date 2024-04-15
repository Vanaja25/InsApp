package com.insuranceapplication.demo.models.services;

import com.insuranceapplication.demo.data.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();


    List<Customer> getCustomerProfile();

    Customer saveCustomer(Customer customer);

    Customer getCustomerById(Long id);
    Customer updateCustomer(Customer customer);

    void removeCustomerById(Long id);
}

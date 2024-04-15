package com.insuranceapplication.demo.models.services;

import com.insuranceapplication.demo.data.entities.Customer;
import com.insuranceapplication.demo.data.repositories.CustomerRepository;
import com.insuranceapplication.demo.models.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomerProfile() {

        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void removeCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (((Optional<?>) customerOptional).isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new CustomerNotFoundException("Zákazník s id " + id + " neexistuje.");
        }
    }

}


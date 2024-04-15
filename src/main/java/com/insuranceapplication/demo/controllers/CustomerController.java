package com.insuranceapplication.demo.controllers;

import com.insuranceapplication.demo.data.entities.Customer;
import com.insuranceapplication.demo.models.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //handler method to handle list students and return mode and view
    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/customers/new")
    public String createCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create_customer";
    }


    @PostMapping("/customers")
    public String saveCustomers(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomerForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "edit_customer";
    }

    @PostMapping("/customers/{id}")
    public String updateCustomer(@PathVariable Long id, @ModelAttribute("customer") Customer customer, Model model) {
        //get customer from db by id
        Customer existingCustomer = customerService.getCustomerById(id);
        existingCustomer.setId(id);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setSecondName(customer.getSecondName());
        existingCustomer.setEmail(customer.getEmail());

        //save udpated customer object
        customerService.updateCustomer(existingCustomer);
        return "redirect:/customers";
    }

    //handler method to delete customer
    @GetMapping("/customers/{id}")
    public String removeCustomerById(@PathVariable Long id) {
        customerService.removeCustomerById(id);
        return "redirect:/customers";
    }

    @GetMapping("/customers/profile/{id}")
    public String getCustomerProfile(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);

        if (customer != null) {
            model.addAttribute("customer", customer);
        } else {
            model.addAttribute("errorMessage", "Customer with ID " + id + " was not found.");
        }

        return "profile";
    }


}

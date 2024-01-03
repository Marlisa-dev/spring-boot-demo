package com.example.demo.customer;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequestMapping(path = "api/v2/customers") // give api correct naming convention plus versioning

@RestController
public class CustomerControllerV2 {

    private final CustomerService customerService;

    //Constructor
    @Autowired //@Autowired to inject CustomerService in the controller
    public CustomerControllerV2(CustomerService customerService){

        this.customerService = customerService;
    }
    //Our Method for list of customers
    @GetMapping //This tells spring that this method is a resource that a client can consume
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    //Our Method for a single customer
    @GetMapping(path = "{customerId}") //@GetMapping tells spring that this method is a resource that a client can consume
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    void createNewCustomer(@RequestBody @Valid Customer customer){
        //@RequestBody is to retrieve the json payload and map it into customer
        //@valid prevents you from posting bank data. from sprig validation dependency
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        //@RequestBody is to retrieve the json payload and map it into customer
        System.out.println("UPDATE REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
//        System.out.println(customer);
    }
}

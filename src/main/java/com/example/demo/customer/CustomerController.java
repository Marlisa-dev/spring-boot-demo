package com.example.demo.customer;

import com.example.demo.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1/customer") // give api correct naming convention plus versioning
@RestController
@Deprecated
public class CustomerController {

    private final CustomerService customerService;

    //Constructor
    @Autowired //@Autowired to inject CustomerService in the controller
    public CustomerController(CustomerService customerService){

        this.customerService = customerService;
    }
    //Our Method
    @GetMapping(value = "all") // give api correct naming convention plus versioning using the value
    //This tells spring that this method is a resource that a client can consume
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    void createNewCustomer(@RequestBody Customer customer){
        //@RequestBody is to retrieve the json payload and map it into customer
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

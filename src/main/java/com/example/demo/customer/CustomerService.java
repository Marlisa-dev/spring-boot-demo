package com.example.demo.customer;

import exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
//@Component will instanciate the customer service class in customerController.
// This creates a bean that you can inject in multiple places.
//CustomerService here is a singleton, so you get the same instance if you inject in multiple places

public class CustomerService {

    //logging instance
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);


    private final CustomerRepo customerRepo;
    @Autowired
    public CustomerService(
            CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }

    Customer getCustomer(Long id) {
        return getCustomers()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()

                //.orElseThrow(() -> new NotFoundException("customer with id " + id + " not found")); //not this works
                //Example below is just to see how uing the logger works
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException = new NotFoundException("customer with id " + id + " not found");
                            LOGGER.error("error in getting customer {}", id, notFoundException);
                            return notFoundException;
                        });
    }
}

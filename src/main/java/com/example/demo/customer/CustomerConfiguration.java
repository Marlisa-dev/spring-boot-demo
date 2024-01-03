package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")

    private Boolean useFakeCustomerRepo;
    @Bean
        //tell bean this needs to be initialized
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Command Line Runner hooray");
        };
    }



    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return useFakeCustomerRepo ?
                new CustomerFakeRepository() :
                new CustomerRepository();
                }
    }


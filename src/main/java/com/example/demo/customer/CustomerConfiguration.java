package com.example.demo.customer;

import com.example.demo.infoapp.InfoApp;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")



    private Boolean useFakeCustomerRepo;
    @Bean
        //tell bean this needs to be initialized
    CommandLineRunner commandLineRunner(InfoApp infoApp) {
        return args -> {
            System.out.println("Command Line Runner hooray");
            System.out.println(infoApp);
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


package com.example.demo.customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//Our Customer class
public class Customer {
    private final Long id;

    @NotBlank(message = "name must not be empty") //from spring validation dependency to prevent posting blank data. This will only work when you add @valid in the Post request controller
    private final String name;

    @NotBlank(message = "password must not be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //allows you to post a password for testing etc
    private final String password;

    @NotBlank(message = "email must not be empty")
    @Email //this annotation will validate email for us.
    //@Email(regexp = ".*") [Adding regex here will make the validation stricter]
    private final String email;


    //Our constructor
    public Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    //Our Getters. Only getters because the class is final
    @JsonProperty("customerId") //change data sent from id to customerId
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @JsonIgnore //prevents this info from going back to client if it's supposed to be a secret like password
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

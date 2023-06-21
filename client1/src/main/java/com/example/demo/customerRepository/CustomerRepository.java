package com.example.demo.customerRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.customerEntity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}

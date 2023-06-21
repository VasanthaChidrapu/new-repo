package com.example.demo.customerServiceInterface;

import java.util.List;

import com.example.demo.customerEntity.Customer;

public interface customerInterface {
	public Customer createCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(String customerId);
	public Customer updateCustomer(String customerId, Customer customer);
	public boolean deleteCustomer(String customerId);

}

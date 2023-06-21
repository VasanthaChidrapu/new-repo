package com.example.demo.customerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customerEntity.Customer;
import com.example.demo.customerRepository.CustomerRepository;
import com.example.demo.customerServiceInterface.customerInterface;

@Service
public class CustomerService implements customerInterface{
	@Autowired
	private CustomerRepository customerRepository;
	
	public class ServiceException extends RuntimeException {
		public ServiceException(String message) {
			super(message);
		}
	}
	@Override
	public Customer createCustomer(Customer customer) {
		try {
			return customerRepository.save(customer);
		} catch (Exception e) {
			throw new ServiceException("Error creating customer: " + e.getMessage());
		}
		//return customerRepository.save(customer);
	}
	@Override
	 public List<Customer> getAllCustomers() {
	       // return customerRepository.findAll();
		try {
			return customerRepository.findAll();
		} catch (Exception e) {
			throw new ServiceException("Error getting all customers: " + e.getMessage());
		}
	    }
	@Override
	 public Customer getCustomerById(String customerId) {
		System.out.println("inside get by id"+customerId);
	        Optional<Customer> customerOptional = customerRepository.findById(customerId);
	        return customerOptional.orElse(null);
//			Optional<Customer> customerOptional = customerRepository.findById(customerId);
//			if (customerOptional.isPresent()) {
//				return customerOptional.get();
//			} else {
//				throw new ServiceException("Customer not found with id: " + customerId);
//			}
	    }
	@Override
	  public Customer updateCustomer(String customerId, Customer customer) {
	        Optional<Customer> customerOptional = customerRepository.findById(customerId);
	        if (customerOptional.isPresent()) {
	            customer.setCustomerId(customerId);
	            return customerRepository.save(customer);
	        } else {
	            //return null;
	            throw new ServiceException("Customer not found with id: " + customerId);
	        }
	    }
	@Override
	  public boolean deleteCustomer(String customerId) {
//	        Optional<Customer> customerOptional = customerRepository.findById(customerId);
//	        if (customerOptional.isPresent()) {
//	            customerRepository.deleteById(customerId);
//	            return true;
//	        } else {
//	            return false;
//	        }
		try {
			customerRepository.deleteById(customerId);
			return true;
		} catch (Exception e) {
			throw new ServiceException("Error deleting customer with id " + customerId + ": " + e.getMessage());
		}
	}


}

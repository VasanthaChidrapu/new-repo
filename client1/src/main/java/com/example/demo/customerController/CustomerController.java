package com.example.demo.customerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customerEntity.Customer;
import com.example.demo.customerService.CustomerService;
import com.example.demo.customerServiceInterface.customerInterface;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private customerInterface customerInterface;
	
//	 @PostMapping("/add")
//	    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
//	        Customer createdCustomer = customerInterface.createCustomer(customer);
//	        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
//	    }
	@PostMapping("/add")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	    try {
	        Customer createdCustomer = customerInterface.createCustomer(customer);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
	    } catch (IllegalArgumentException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    } catch (Exception ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	
//	 @GetMapping("/get")
//	    public ResponseEntity<List<Customer>> getAllCustomers() {
//	        List<Customer> customers = customerInterface.getAllCustomers();
//	        return ResponseEntity.ok(customers);
//	    }
	@GetMapping("/get")
	public ResponseEntity<List<Customer>> getAllCustomers() {
	    try {
	        List<Customer> customers = customerInterface.getAllCustomers();
	        return ResponseEntity.ok(customers);
	    } catch (Exception ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

//	 @GetMapping("/get/{customerId}")
//	    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) {
//	        Customer customer = customerInterface.getCustomerById(customerId);
//	        if (customer != null) {
//	            return ResponseEntity.ok(customer);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
	 @GetMapping("/get/{customerId}")
	 public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) {
	     try {
	         Customer customer = customerInterface.getCustomerById(customerId);
	         if (customer != null) {
	             return ResponseEntity.ok(customer);
	         } else {
	             return ResponseEntity.notFound().build();
	         }
	     } catch (IllegalArgumentException ex) {
	         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	     } catch (Exception ex) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	     }
	 }
//
//	 @PutMapping("/put/{customerId}")
//	    public ResponseEntity<Customer> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
//	        Customer updatedCustomer = customerInterface.updateCustomer(customerId, customer);
//	        if (updatedCustomer != null) {
//	            return ResponseEntity.ok(updatedCustomer);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
	 @PutMapping("/put/{customerId}")
	 public ResponseEntity<Customer> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
	     try {
	         Customer updatedCustomer = customerInterface.updateCustomer(customerId, customer);
	         if (updatedCustomer != null) {
	             return ResponseEntity.ok(updatedCustomer);
	         } else {
	             return ResponseEntity.notFound().build();
	         }
	     } catch (IllegalArgumentException ex) {
	         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	     } catch (Exception ex) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	     }
	 }

//	 @DeleteMapping("/delete/{customerId}")
//	    public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId) {
//	        boolean deleted = customerService.deleteCustomer(customerId);
//	        if (deleted) {
//	            return ResponseEntity.noContent().build();
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
	 @DeleteMapping("/delete/{customerId}")
	 public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId) {
	     try {
	         boolean deleted = customerService.deleteCustomer(customerId);
	         if (deleted) {
	             return ResponseEntity.noContent().build();
	         } else {
	             return ResponseEntity.notFound().build();
	         }
	     } catch (Exception ex) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	     }
	 }


}

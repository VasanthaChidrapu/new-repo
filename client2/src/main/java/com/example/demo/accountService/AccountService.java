package com.example.demo.accountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.accountEntity.Account;
import com.example.demo.accountRepository.AccountRepository;
import com.example.demo.accountServiceInterface.AccountInterface;
import com.example.demo.entity.Customer;
import com.example.demo.response.AccountResponse;
import com.example.demo.response.CustomerResponse;

import reactor.core.publisher.Mono;

@Service
public class AccountService implements AccountInterface{
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private WebClient webClient;

//	@Autowired
//	private CustomerRepository customerRepository;
	
	// Fetch customer details by ID
	//CustomerResponse customerResponse = getCustomerById(account.getCustomerId());
	// account.setCustomerName(customerResponse.getCustomerName());
	@Override
	public Account createAccount(Account account) {

		return accountRepository.save(account);
	}
	
//	public Account createAccount(Account account,CustomerResponse customerResponse) {
//		if(account.getCustomerId() == null) {
//			
//        Customer customer = new Customer(customerResponse.getCustomerId(),
//        		customerResponse.getCustomerName(),
//        		customerResponse.getDateOfBirth(),
//	        		customerResponse.getGender(),
//	        		customerResponse.getPhoneNumber());
//	        String customerUrl = "http://localhost:8080/api/add";
//	        WebClient customerClient = WebClient.create();
//	        Customer createdCustomer = customerClient.post()
//	                .uri(customerUrl)
//	                .bodyValue(customer)
//	                .retrieve()
//	                .bodyToMono(Customer.class)
//	                .block();
//	        account.setCustomerId(createdCustomer.getCustomerId());
//	       // customerRepository.save(customer);
//	      
//		
//		}
//		
//		return accountRepository.save(account);
//		
//	}
	// accountResponse.setCustomerResponse(getCustomerById(account.getAccountId()));
	@Override
	public AccountResponse getById(String accountId) {
		Account account = accountRepository.findById(accountId).get();
	
        AccountResponse accountResponse = new AccountResponse(account);
		accountResponse.setCustomerResponse(getCustomerById(account.getCustomerId()));

		return accountResponse;
		
		
	}
	@Override
	public Account updateAccount(String accountId, Account updatedAccount){
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + accountId));

		// Update account fields
		account.setAccountType(updatedAccount.getAccountType());
		account.setOpenDate(updatedAccount.getOpenDate());
		account.setBranch(updatedAccount.getBranch());
		// account.setCustomerId(updatedAccount.getCustomerId());
		// account.setCustomerName(updatedAccount.getCustomerName());
		account.setMinorIndicator(updatedAccount.getMinorIndicator());
		// Save updated account to database
		return accountRepository.save(account);
	}
	@Override
	public void deleteAccount(String accountId) {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + accountId));

		// Delete account from database
		accountRepository.delete(account);
	}
	


	public CustomerResponse getCustomerById(String customerId) {
		Mono<CustomerResponse> customerResponse = webClient.get().uri("/get/" + customerId).retrieve()
				.bodyToMono(CustomerResponse.class);

		return customerResponse.block();
	}

//	public CustomerResponse createNewCustomer(CustomerResponse customerResponse) {
//	Mono<CustomerResponse> customerResponse1 = webClient.post().uri("/add").retrieve()
//				.bodyToMono(CustomerResponse.class);
//
//		return customerResponse1.block();
//	}

}

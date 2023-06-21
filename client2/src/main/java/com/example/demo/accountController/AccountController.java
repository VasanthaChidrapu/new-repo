package com.example.demo.accountController;

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

import com.example.demo.accountEntity.Account;
import com.example.demo.accountService.AccountService;
import com.example.demo.accountService.ResourceNotFoundException;
import com.example.demo.accountServiceInterface.AccountInterface;
import com.example.demo.response.AccountResponse;
import com.example.demo.response.CustomerResponse;

@RestController
@RequestMapping("/api2")
public class AccountController{
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountInterface accountInterface;
	
//	 @PostMapping("/add2")
//	    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
//			Account createdAccount = accountInterface.createAccount(account);
//	        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
//	    }
	@PostMapping("/add2")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) throws Exception {
	    try {
	        Account createdAccount = accountInterface.createAccount(account);
	        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
	    } catch (IllegalArgumentException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    } catch (Exception ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

//	 @PostMapping("/add2")
//	    public ResponseEntity<Account> createAccount(@RequestBody Account account,CustomerResponse customerResponse) {
//			Account createdAccount = accountInterface.createAccount(account, customerResponse);
//	        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
//	    }
	 


//	 @GetMapping("get/{accountId}")
//		public AccountResponse getById (@PathVariable String accountId) {
//			return accountInterface.getById(accountId);
//		}
//	 @PutMapping("/put/{accountId}")
//	 public ResponseEntity<Account> updateAccount(@PathVariable String accountId, @RequestBody Account updatedAccount) {
//	     Account account = accountInterface.updateAccount(accountId, updatedAccount);
//	     return new ResponseEntity<>(account, HttpStatus.OK);
//	 }
	 @DeleteMapping("/delete/{accountId}")
	 public ResponseEntity<String> deleteAccount(@PathVariable String accountId) {
//		 accountInterface.deleteAccount(accountId);
//	     return new ResponseEntity<>("Account with id " + accountId + " has been deleted.", HttpStatus.OK);
		 try {
	         accountService.deleteAccount(accountId);
	         return ResponseEntity.ok("Account deleted successfully");
	     } catch (ResourceNotFoundException ex) {
	         return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                 .body("Account not found with id " + accountId);
	     }
	 }

	 @GetMapping("get/{accountId}")
	 public ResponseEntity<AccountResponse> getById(@PathVariable String accountId) {
	     try {
	         AccountResponse accountResponse = accountInterface.getById(accountId);
	         return ResponseEntity.ok(accountResponse);
	     } catch (ResourceNotFoundException ex) {
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	     }
	 }
	 @PutMapping("/put/{accountId}")
	 public ResponseEntity<Account> updateAccount(@PathVariable String accountId, @RequestBody Account updatedAccount) {
	     try {
	         Account account = accountInterface.updateAccount(accountId, updatedAccount);
	         return new ResponseEntity<>(account, HttpStatus.OK);
	     } catch (ResourceNotFoundException ex) {
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	     } catch (IllegalArgumentException ex) {
	         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	     } catch (Exception ex) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	     }
	 }




}

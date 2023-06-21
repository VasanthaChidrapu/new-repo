package com.example.demo.response;

import java.sql.Date;
import java.time.LocalDate;

import com.example.demo.accountEntity.Account;

public class AccountResponse {
	
	private String accountId;
	private String accountType;
	private LocalDate openDate;
	private String branch;
	private char minorIndicator;
	private CustomerResponse customerResponse;
	 public AccountResponse() {
	    }

	public AccountResponse(Account account) {
	super();
	this.accountId = account.getAccountId();
	this.accountType = account.getAccountType();
	this.openDate = account.getOpenDate();
	this.branch = account.getBranch();
	//this.customerId = account.getCustomerId();
	 //this.customerName = account.getCustomerName();
	this.minorIndicator = account.getMinorIndicator();
}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public char getMinorIndicator() {
		return minorIndicator;
	}

	public void setMinorIndicator(char minorIndicator) {
		this.minorIndicator = minorIndicator;
	}

	public CustomerResponse getCustomerResponse() {
		return customerResponse;
	}

	public void setCustomerResponse(CustomerResponse customerResponse) {
		this.customerResponse = customerResponse;
	}
	
}

package com.example.demo.accountEntity;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {
	@Id
	private String accountId;
	private String accountType;
	private LocalDate openDate = LocalDate.now();
	private String branch;
	@Column(nullable = false)
	private String customerId;
	//private String customerName;
	private char minorIndicator;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	//String customerName, 
	public Account(String accountId, String accountType, LocalDate openDate, String branch, String customerId,
			char minorIndicator) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.openDate = openDate;
		this.branch = branch;
		this.customerId = customerId;
		//this.customerName = customerName;
		this.minorIndicator = minorIndicator;
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
//	public String getCustomerName() {
//		return customerName;
//	}
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
	public char getMinorIndicator() {
		return minorIndicator;
	}
	public void setMinorIndicator(char minorIndicator) {
		this.minorIndicator = minorIndicator;
	}
//	+ ", customerName=" + customerName
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", openDate=" + openDate
				+ ", branch=" + branch + ", customerId=" + customerId + ", minorIndicator=" + minorIndicator + "]";
	}
	
	

}

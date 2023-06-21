package com.example.demo.accountServiceInterface;

import com.example.demo.accountEntity.Account;
import com.example.demo.response.AccountResponse;

public interface AccountInterface {
	public Account createAccount(Account account);
	public AccountResponse getById(String accountId);
	public Account updateAccount(String accountId, Account updatedAccount);
	public void deleteAccount(String accountId);

}

package com.example.demo.accountRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.accountEntity.Account;
import com.example.demo.response.AccountResponse;
@Repository
public interface AccountRepository extends JpaRepository<Account, String>{

	AccountResponse save(AccountResponse account);

}

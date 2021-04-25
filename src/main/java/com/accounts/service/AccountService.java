package com.accounts.service;

import java.util.List;

import com.accounts.model.Accounts;

public interface AccountService {

	public List<Accounts> getAccounts();
	
	public Accounts getAccountById(Long id);
	
	public void createAccount(Accounts account);
	
	public void updateAccount(Accounts account);
	
	public void delete(Long Id);
}

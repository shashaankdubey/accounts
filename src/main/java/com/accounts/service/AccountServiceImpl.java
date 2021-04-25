package com.accounts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.accounts.model.Accounts;
import com.accounts.repository.AccountsRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountsRepository accountsRepository;
	
	@Override
	public List<Accounts> getAccounts() {
		return this.accountsRepository.findAll();
	}

	@Override
	public Accounts getAccountById(Long id) {
		return this.accountsRepository.findById(id).get();
	}

	@Override
	public void createAccount(Accounts account) {
		this.accountsRepository.save(account);
	}

	@Override
	public void updateAccount(Accounts account) {
		this.accountsRepository.save(account);
		
	}

	@Override
	public void delete(Long id) {
		this.accountsRepository.deleteById(id);
	}

}

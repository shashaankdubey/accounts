package com.accounts.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.model.Accounts;
import com.accounts.service.AccountService;

@Validated
@RestController
public class AccountsController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(path="/accounts" , method=RequestMethod.GET)
	public List<Accounts> getAccounts() {
		List<Accounts> accounts = this.accountService.getAccounts();
		return accounts;
	}
	
	@RequestMapping(path="/accounts/{id}" , method=RequestMethod.GET)
	public Accounts getAccountById(@PathVariable("id")Long id) {
		Accounts account = this.accountService.getAccountById(id);
		return account;
	}
	
	@RequestMapping(path="/accounts/create" , method=RequestMethod.POST)
	public String createAccount(@RequestBody @Valid Accounts account) {
		this.accountService.createAccount(account);
		return "OK Created";
	}
	
	@RequestMapping(path="/accounts/update" , method=RequestMethod.PUT)
	public String updateAccount(@RequestBody @Valid Accounts account) {
		this.accountService.updateAccount(account);
		return "OK Updated";
	}
	
	@RequestMapping(path="/accounts/delete/{id}" , method=RequestMethod.DELETE)
	public String deleteAccount(@PathVariable("id")Long id) {
		try {
			this.accountService.delete(id);
			return "Deleted";
		} catch(EmptyResultDataAccessException ex) {
			return "No Such Records";
		}
	}
	
}

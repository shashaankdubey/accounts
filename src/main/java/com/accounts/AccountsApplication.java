package com.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.accounts.service.AccountService;
import com.accounts.service.AccountServiceImpl;

@SpringBootApplication
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

	@Bean
	public AccountService accountService() {
		return new AccountServiceImpl();
	}
}

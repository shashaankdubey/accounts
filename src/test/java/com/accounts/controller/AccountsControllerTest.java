package com.accounts.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.accounts.AccountsApplication;
import com.accounts.model.Accounts;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AccountsApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(
  locations = "classpath:application-test.properties")
public class AccountsControllerTest {

	@LocalServerPort
    private int port;
 
    @Autowired
    private TestRestTemplate restTemplate;
	
	@Sql({ "classpath:data.sql" })
    @Test
	public void testAccountCreation() {

		Accounts account = new Accounts();
		account.setId(12L);
		account.setName("Name");
		account.setPhone("123456789");
		account.setCountry("USA");
		account.setEmail("email@email.com");
		account.setDepartment("DEPT");
		String response = this.restTemplate
                .postForObject("http://localhost:" + port + "/accounts/create",account ,String.class);
		assertEquals(response,"OK Created");
		
		Accounts accountRes = this.restTemplate
				.getForObject("http://localhost:" + port + "/accounts/12", Accounts.class);
		assertEquals(accountRes.getName(),"Name");
	}

}

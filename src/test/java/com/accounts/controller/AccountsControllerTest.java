package com.accounts.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
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
	
	@SuppressWarnings("unchecked")
	@Sql({ "classpath:data.sql" })
    @Test
	public void testAccountCreationFailure() {

		Accounts account = new Accounts();
		account.setId(12L);
		account.setName("Name");
		account.setPhone("9999999999999999999999999");
		account.setCountry("USA");
		account.setEmail("email@email.com");
		account.setDepartment("DEPT");
		ResponseEntity<Map> response = this.restTemplate
                .postForEntity("http://localhost:" + port + "/accounts/create",account ,Map.class);
		List<String> errors = (List<String>) response.getBody().get("errors");
		assertEquals(errors.get(0),"Phone should be between 9 and 12 digits");
	}	

}

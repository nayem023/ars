package com.ars;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)

public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
	    User user = new User();
	    user.setEmailAdd("meannfrancisco26@protonmail.com");
	    user.setPassword("Pass12345");
	    user.setFirstName("Gregory");
	    user.setMiddleName("McDewey");
	    user.setLastName("Hansons");
	    user.setContactNum("09123456789");
	    
	    
	     
	    User savedUser = repo.save(user);
	     
	    User existUser = entityManager.find(User.class, savedUser.getCustomer_id());
	     
	    assertThat(user.getEmailAdd()).isEqualTo(existUser.getEmailAdd());
	     
	}
	
	@Test
	public void testUserByEmail() {
		String emailAdd = "mea1nnfrancisco26@protonmail.com";
		User user = repo.findByEmail(emailAdd);
		assertThat(user).isNotNull();
	
	}
	
	

}

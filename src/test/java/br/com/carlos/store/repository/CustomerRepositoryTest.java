package br.com.carlos.store.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.carlos.store.model.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

	private static final long CUSTOMER_ID_FOR_TEST = 1l;

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testFindCustomer(){
		Customer customerToSaveOnDatabase = getExpectedCustomer();
		customerToSaveOnDatabase.setId(null);//remove id for database GenerateValue
		this.entityManager.persist(customerToSaveOnDatabase);
		
		Customer customer = customerRepository.findOne(CUSTOMER_ID_FOR_TEST);
		assertThat(customer, equalTo(getExpectedCustomer()));
	}
	
	
	private Customer getExpectedCustomer(){
		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(CUSTOMER_ID_FOR_TEST);
		expectedCustomer.setDocument("356.854.453-87");
		expectedCustomer.setName("Carlos Eduardo Proença Silva");
		expectedCustomer.setEmail("carlos_proenca@live.com");
		
		return expectedCustomer; 
	}

}
package br.com.carlos.store.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.carlos.store.model.Customer;
import br.com.carlos.store.repository.CustomerRepository;
import br.com.carlos.store.util.annotation.RestService;

@RestService
@RequestMapping("/customers")
public class CustomerResource extends GenericResource<Customer, Long>{
	
	@Autowired
	public CustomerResource(CustomerRepository customerRepository) {
		super(customerRepository);		
	}
}
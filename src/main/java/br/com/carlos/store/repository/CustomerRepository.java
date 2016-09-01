package br.com.carlos.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carlos.store.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

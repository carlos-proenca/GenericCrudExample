package br.com.carlos.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carlos.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

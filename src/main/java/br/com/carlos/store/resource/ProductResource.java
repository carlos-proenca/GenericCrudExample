package br.com.carlos.store.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.carlos.store.model.Product;
import br.com.carlos.store.repository.ProductRepository;
import br.com.carlos.store.util.annotation.RestService;

@RestService
@RequestMapping("/products")
public class ProductResource extends GenericResource<Product, Long>{
	
	@Autowired
	public ProductResource(ProductRepository productRepository) {
		super(productRepository);		
	}
}
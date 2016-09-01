package br.com.carlos.store.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface GenericService<Entity, ID extends Serializable> {
	
	List<Entity> getAll();
	
	Entity getById(ID id);
	
	Entity save(Entity entity);
	
	void delete(ID id);

	public void setGenericSpringRepository(JpaRepository<Entity, ID> genericSpringRepository);
}
package br.com.carlos.store.service.provider;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.carlos.store.service.GenericService;

@Service
public class GenericServiceProvider<Entity, ID extends Serializable> implements GenericService<Entity, ID>{

//	@Autowired
	private JpaRepository<Entity, ID> genericSpringRepository;
	
	@Override
	public List<Entity> getAll() {
		return genericSpringRepository.findAll();
	}

	@Override
	public Entity getById(ID id) {
		return genericSpringRepository.findOne(id);
	}

	@Override
	public Entity save(Entity entity) {
		return genericSpringRepository.save(entity);
	}

	@Override
	public void delete(ID id) {
		genericSpringRepository.delete(id);
 	}


	public void setGenericSpringRepository(JpaRepository<Entity, ID> genericSpringRepository) {
		this.genericSpringRepository = genericSpringRepository;
	}
}

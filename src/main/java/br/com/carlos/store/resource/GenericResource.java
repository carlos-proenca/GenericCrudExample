package br.com.carlos.store.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.carlos.store.service.GenericService;

public class GenericResource <Entity, ID extends Serializable>{
	
	private GenericService<Entity, ID>	genericService;
	
	private JpaRepository<Entity, ID> repository;
	
	protected GenericResource(JpaRepository<Entity, ID> repository){
		this.repository = repository;
	}


	@RequestMapping(method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Entity>> getAll(){
		return new ResponseEntity<List<Entity>>(getGenericService().getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Entity> getById(@RequestParam ID id){
		return new ResponseEntity<Entity>(getGenericService().getById(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Entity> save(@RequestBody Entity entity){
		return new ResponseEntity<Entity>(getGenericService().save(entity), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestParam ID id){
		getGenericService().delete(id);
	}
	
	public GenericService<Entity, ID> getGenericService(){
		return genericService;
	}
	
	@Autowired
	public void setGenericService(GenericService<Entity, ID> genericService){
		genericService.setGenericSpringRepository(repository);
		this.genericService = genericService;
	}
}
package com.lol.lolRandomMatch.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lol.lolRandomMatch.domain.Build;
import com.lol.lolRandomMatch.service.BuildService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/builds")
public class BuildResource {
	
	@Autowired
	private BuildService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Build> findById(@PathVariable Integer id) {	
		
		Build obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity< List<Build> > findAll() {
		
		List<Build> list = service.findAll();
//		List<Build> listDTO = list.stream().map( obj -> new Build(obj) ).collect( Collectors.toList() );
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/random")
	public ResponseEntity<Build> findRandom() {
		
		Build obj = service.findRandom();
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Build> create( @Valid @RequestBody Build obj ) {
		
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( obj.getId() ).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Build> update( @PathVariable Integer id, @Valid @RequestBody Build objDto ) {
		
		Build newObj = service.update(id, objDto);
		
		return ResponseEntity.ok().body( new Build() );
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete( @PathVariable Integer id ){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}

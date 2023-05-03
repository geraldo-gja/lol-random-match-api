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

import com.lol.lolRandomMatch.domain.Champion;
import com.lol.lolRandomMatch.service.ChampionService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/champions")
public class ChampionResource {
	
	@Autowired
	private ChampionService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Champion> findById(@PathVariable Integer id) {	
		
		Champion obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity< List<Champion> > findAll() {
		
		List<Champion> list = service.findAll();
//		List<Champion> listDTO = list.stream().map( obj -> new Champion(obj) ).collect( Collectors.toList() );
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/random")
	public ResponseEntity<Champion> findRandom() {
		
		Champion obj = service.findRandom();
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Champion> create( @Valid @RequestBody Champion obj ) {
		
		obj= service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( obj.getId() ).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Champion> update( @PathVariable Integer id, @Valid @RequestBody Champion objDto ) {
		
		service.update(id, objDto);
		
		return ResponseEntity.ok().body( new Champion() );
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete( @PathVariable Integer id ){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}

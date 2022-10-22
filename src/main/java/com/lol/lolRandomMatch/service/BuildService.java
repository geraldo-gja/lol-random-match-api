package com.lol.lolRandomMatch.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lol.lolRandomMatch.domain.Build;
import com.lol.lolRandomMatch.repositories.BuildRepository;

@Service
public class BuildService {
	
	@Autowired
	private BuildRepository repository;

	public Build findById( Integer id) {
		Optional<Build> obj = repository.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrato! Id: " + id + ", Tipo: " + Build.class.getName(), null ) );
	}
	
	public List<Build> findAll() {
		return repository.findAll();
	}
	
	public Build findRandom() {
		
		List<Build> builds = repository.findAll();
		int idRandom = new Random().nextInt(builds.size());
						
		return builds.get(idRandom);
	}
	
	public Build create(Build obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Build update(Integer id, Build objDto) {
		
		Build obj = findById(id);
		obj.setName(objDto.getName());
		
		return repository.save(obj);
	}

	public void delete(Integer id) {
		
		findById(id);
		repository.deleteById(id);
	}
	
	
}

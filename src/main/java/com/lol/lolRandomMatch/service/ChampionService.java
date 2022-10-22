package com.lol.lolRandomMatch.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lol.lolRandomMatch.domain.Champion;
import com.lol.lolRandomMatch.repositories.ChampionRepository;

@Service
public class ChampionService {
	
	@Autowired
	private ChampionRepository repository;

	public Champion findById( Integer id) {
		Optional<Champion> obj = repository.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrato! Id: " + id + ", Tipo: " + Champion.class.getName(), null ) );
	}
	
	public List<Champion> findAll() {
		return repository.findAll();
	}
	
	public Champion findRandom() {
		
		List<Champion> champs = repository.findAll();
		
		Random random = new Random();
		int idRandom = random.nextInt(champs.size());
						
		return champs.get(idRandom);
	}
	
	public Champion create(Champion obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Champion update(Integer id, Champion objDto) {
		
		Champion obj = findById(id);
		obj.setName(objDto.getName());
		
		return repository.save(obj);
	}

	public void delete(Integer id) {
		
		findById(id);
		repository.deleteById(id);
	}
	
	
}

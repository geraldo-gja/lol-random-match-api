package com.lol.lolRandomMatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lol.lolRandomMatch.domain.Champion;
import com.lol.lolRandomMatch.repositories.ChampionRepository;


@Service
public class DBService {

	@Autowired
	private ChampionRepository championRepository;
	
	public void instanciaBaseDeDados() {
		
		Champion c = new Champion(null, "Master Yi");
		
		this.championRepository.save(c);
	}
}

package com.lol.lolRandomMatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lol.lolRandomMatch.domain.Champion;
import com.lol.lolRandomMatch.domain.Build;

import com.lol.lolRandomMatch.repositories.BuildRepository;
import com.lol.lolRandomMatch.repositories.ChampionRepository;

@Service
public class DBService {

	@Autowired
	private ChampionRepository championRepository;
	
	@Autowired
	private BuildRepository buildRepository;
	
	public void instanciaBaseDeDados() {
		
		Champion c = new Champion(null, "Master Yi");
		Build b = new Build(null, "Lutador");
		
		this.championRepository.save(c);
		this.buildRepository.save(b);
		
		//System.out.println("Nome: " + buildRepository.findById(1) );
	}

}

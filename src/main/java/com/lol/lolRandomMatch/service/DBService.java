package com.lol.lolRandomMatch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lol.lolRandomMatch.domain.Build;
import com.lol.lolRandomMatch.domain.Champion;
import com.lol.lolRandomMatch.repositories.BuildRepository;
import com.lol.lolRandomMatch.repositories.ChampionRepository;

@Service
public class DBService {

	@Autowired
	private ChampionRepository championRepository;
	
	@Autowired
	private BuildRepository buildRepository;
	
	public void instanciaBaseDeDados() {
		
		List<Champion> championList = new ArrayList<>();
		List<Build> buildList = new ArrayList<>();
		
		championList.add(new Champion(null, "Master Yi"));
		championList.add(new Champion(null, "Rammus"));
		championList.add(new Champion(null, "Kassadin"));
		championList.add(new Champion(null, "Viktor"));
		championList.add(new Champion(null, "Syndra"));
		championList.add(new Champion(null, "Anivia"));
		championList.add(new Champion(null, "Zoe"));
		championList.add(new Champion(null, "Zac"));
		championList.add(new Champion(null, "Talon"));
		championList.add(new Champion(null, "Alistar"));
		championList.add(new Champion(null, "Annie"));
		championList.add(new Champion(null, "Hecarim"));
		championList.add(new Champion(null, "Ornn"));
		championList.add(new Champion(null, "Orianna"));
		championList.add(new Champion(null, "Azir"));
		championList.add(new Champion(null, "Irelia"));
		championList.add(new Champion(null, "Lee sin"));
		championList.add(new Champion(null, "Thresh"));
		championList.add(new Champion(null, "Bardo"));
		championList.add(new Champion(null, "Amumu"));
		
		buildList.add(new Build(null, "Assassino"));
		buildList.add(new Build(null, "Lutador"));
		buildList.add(new Build(null, "Mago"));
		buildList.add(new Build(null, "Atiradr"));
		buildList.add(new Build(null, "Suporte"));
		buildList.add(new Build(null, "Tanque"));
		
		this.championRepository.saveAll(championList);
		this.buildRepository.saveAll(buildList);
	}
}

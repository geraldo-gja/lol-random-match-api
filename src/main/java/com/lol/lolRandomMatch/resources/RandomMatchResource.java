package com.lol.lolRandomMatch.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lol.lolRandomMatch.domain.Build;
import com.lol.lolRandomMatch.domain.Champion;
import com.lol.lolRandomMatch.domain.Lane;
import com.lol.lolRandomMatch.dtos.RandomChampionDTO;
import com.lol.lolRandomMatch.service.BuildService;
import com.lol.lolRandomMatch.service.ChampionService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/randomMatch")
public class RandomMatchResource {

	@Autowired
	private ChampionService champService;
	
	@Autowired
	private BuildService buildService;
	
	private List<Champion> champList;
	private List<Build> buildList;
	
	@GetMapping
	public ResponseEntity< List<RandomChampionDTO> >  findRandom() {
		
		champList = champService.findAll();
		buildList = buildService.findAll();

		List<RandomChampionDTO> randomTeam = new ArrayList<>();
		
		for (int j = 0; j < 2; j++) {  //vai dar 2 loops, o primeiro forma o Time 01, o segundo forma o time 02
					
			for (int i = 1; i < 6; i++) {
				
				Champion champ = generateRandomChampion(); 
				Build build = buildList.get( generateRandomBuild() ) ;
				Lane lane = generateLane(i);
				
				RandomChampionDTO randomChamp = new RandomChampionDTO(champ, build, lane);
				randomTeam.add(randomChamp);
			}
		}

		return ResponseEntity.ok().body(randomTeam);
	}

	private Lane generateLane( int i ) {
		
		Lane lane = null;
		
		switch (i) {
		
			case 1:
				lane = Lane.TOP;
				break;
				
			case 2:
				lane = Lane.JUNGLE;
				break;
				
			case 3:
				lane = Lane.MID;
				break;
				
			case 4:
				lane = Lane.BOTTOM;
				break;
				
			case 5:
				lane = Lane.SUPPORT;
				break;
				
			default:
				break;	
		}
		
		return lane;
	}
	
	private int generateRandomBuild() {
		
		int idRandom = new Random().nextInt( buildList.size() );
		
		return idRandom;
	}
	
	private Champion generateRandomChampion() {
	
		int idRandom = new Random().nextInt( champList.size() );
		Champion champ = champList.get(idRandom);
		champList.remove(idRandom);
		
		return champ;
	}


}

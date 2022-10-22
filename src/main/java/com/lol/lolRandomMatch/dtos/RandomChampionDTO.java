package com.lol.lolRandomMatch.dtos;

import com.lol.lolRandomMatch.domain.*;

public class RandomChampionDTO {
	
	private Champion champ;
	private Build build;
	private Lane lane;
	
	public RandomChampionDTO(Champion champ, Build build, Lane lane) {
		this.champ = champ;
		this.build = build;
		this.lane = lane;
	}
	
	public Champion getChamp() {
		return champ;
	}
	public void setChamp(Champion champ) {
		this.champ = champ;
	}
	public Build getBuild() {
		return build;
	}
	public void setBuild(Build build) {
		this.build = build;
	}
	public Lane getLane() {
		return lane;
	}
	public void setLane(Lane lane) {
		this.lane = lane;
	}
	
	
	
}

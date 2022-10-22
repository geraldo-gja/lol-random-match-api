package com.lol.lolRandomMatch.domain;

public enum Lane {
	
	TOP		(1, "Top"),
	JUNGLE	(2, "Jungle"),
	MID		(3, "Mid"),
	BOTTOM 	(4, "Bottom"),
	SUPPORT (5, "Support");
	
	private Integer id;
	private String lane;
	
	Lane(Integer id, String lane){
		this.id = id;
		this.lane = lane;
	}
	
	public Integer getId() {
		return id;
	}
	public String getLane() {
		return lane;
	}
}

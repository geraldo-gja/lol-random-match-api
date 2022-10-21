package com.lol.lolRandomMatch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Build{
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo BUILD_Name é requerido")
	@Length(min = 2, max = 20, message = "O campo BUILD_Name deve ter entre 2 e 20 caracteres")
	private String buildName;
	
	//TODO Constructor
	public Build() {

	}
	
	public Build(Integer id, String buildName) {
		this.id = id;
		this.buildName = buildName;
	}
	
	//TODO Gets and Setss
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
}

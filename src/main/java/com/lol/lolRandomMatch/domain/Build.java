package com.lol.lolRandomMatch.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Build implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo BUILD_Name é requerido")
	@Length(min = 2, max = 20, message = "O campo BUILD_Name deve ter entre 2 e 20 caracteres")
	private String buildName;
	
	//TODO Constructor
	
	public Build() {
		super();
	}
	public Build(Integer id, String buildName) {
		super();
		this.id = id;
		this.buildName = buildName;
	}
	
	//TODO hashCode and equals
	
	@Override
	public int hashCode() {
		return Objects.hash(buildName, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Build other = (Build) obj;
		return Objects.equals(buildName, other.buildName) && Objects.equals(id, other.id);
	}
	
	//TODO Gets and Sets
	
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

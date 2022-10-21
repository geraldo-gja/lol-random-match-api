package com.lol.lolRandomMatch.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Champion{
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo NAME é requerido")
	@Length(min = 2, max = 20, message = "O campo NAME deve ter entre 2 e 20 caracteres")
	private String name;

	//TODO Constructor
	public Champion() {
		
	}
	public Champion(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Champion(Champion champ) {
		this.id = champ.getId();
		this.name = champ.getName();
	}

	//TODO hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	//TODO Gets and Sets
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

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
public class Champion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo NAME é requerido")
	@Length(min = 2, max = 20, message = "O campo NAME deve ter entre 2 e 20 caracteres")
	private String name;

	//TODO Constructor
	
	public Champion() {
		super();
	}
	public Champion(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	//TODO hashCode and equals

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Champion other = (Champion) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
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

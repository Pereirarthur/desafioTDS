package com.desafio.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imagem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String chaveRemocao;
	private int numAcessos;
	
	public Imagem(){		
	}

	public Imagem(Integer id, String chaveRemocao, int numAcessos) {
		super();
		this.id = id;
		this.chaveRemocao = chaveRemocao;
		this.numAcessos = numAcessos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getChaveRemocao() {
		return chaveRemocao;
	}

	public void setChaveRemocao(String chaveRemocao) {
		this.chaveRemocao = chaveRemocao;
	}

	public int getNumAcessos() {
		return numAcessos;
	}

	public void setNumAcessos(int numAcessos) {
		this.numAcessos = numAcessos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imagem other = (Imagem) obj;
		if (id != other.id)
			return false;
		return true;
	};
	
	
	
}

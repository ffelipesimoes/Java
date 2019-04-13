package br.pro.delfino.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Fabricante extends GenericDomain{
	@Column(length = 50, nullable = false)
	private String descricao;

	public String getFabricante() {
		return descricao;
	}

	public void setFabricante(String descricao) {
		this.descricao = descricao;
	}
	
	
}

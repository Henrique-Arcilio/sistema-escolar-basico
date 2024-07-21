package com.arcilio.henrique.sistema_escolar.model.categorias;

public enum Turno {
	MATUTINO("Noturno"),
	VESPERTINO("Vespertino"),
	NOTURNO("Noturno");
	
	private final String nome;
	
	private Turno(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}

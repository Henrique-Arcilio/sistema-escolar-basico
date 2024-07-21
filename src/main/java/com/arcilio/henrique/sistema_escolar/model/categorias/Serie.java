package com.arcilio.henrique.sistema_escolar.model.categorias;

public enum Serie {
	PRIMEIRA_SERIE("1°"),
	SEGUNDA_SERIE("2°"),
	TERCEIRA_SERIE("3°");
	
	private final String nome;
	
	private Serie(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}

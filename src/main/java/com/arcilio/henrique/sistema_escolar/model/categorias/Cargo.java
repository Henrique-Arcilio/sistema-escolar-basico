package com.arcilio.henrique.sistema_escolar.model.categorias;

public enum Cargo {
	ALUNO("Aluno"),
	PROFESSOR("Professor"),
	DIRETOR("Diretor");
	
	private final String nome;
	
	private Cargo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}


}
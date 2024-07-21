package com.arcilio.henrique.sistema_escolar.model.categorias;

public enum Funcao {
	ALUNO("Aluno"),
	PROFESSOR("Professor"),
	DIRETOR("Diretor");
	
	private final String nome;
	
	private Funcao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}


}
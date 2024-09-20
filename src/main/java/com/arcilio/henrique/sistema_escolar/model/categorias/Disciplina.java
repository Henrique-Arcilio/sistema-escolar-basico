package com.arcilio.henrique.sistema_escolar.model.categorias;

public enum Disciplina {
	SEM_DISCIPLINA("Não leciona"),
	PORTUGUES("Lingua Portuguêsa"),
	MATEMATICA("Matemática Básica"),
	FISICA("Física"),
	QUIMICA("Química"),
	BIOLOGIA("Biologia"),
	HISTORIA("História"),
	GEOGRAFIA("Geografia"),
	ARTES("Artes");

	
	private final String nome;
	
	private Disciplina(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	
}

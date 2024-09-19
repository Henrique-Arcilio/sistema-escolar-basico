package com.arcilio.henrique.sistema_escolar.model.usuarios;

import java.time.LocalDate;

import com.arcilio.henrique.sistema_escolar.model.categorias.Funcao;

public abstract class Usuario {
	
	private Funcao funcao;
	private String nome;
	private String senha;
	private LocalDate nascimento;
	private String matricula;


	public Usuario(Funcao funcao, String nome, String senha, LocalDate nascimento) {
		this.funcao = funcao;
		this.nome = nome;
		this.senha = senha;
		this.nascimento = nascimento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}

package com.arcilio.henrique.sistema_escolar.model.usuarios;

import java.time.LocalDate;

import com.arcilio.henrique.sistema_escolar.model.categorias.Cargo;

public abstract class Usuario {
	
	private Cargo cargo;
	private String nome;
	private String senha;
	private LocalDate nascimento;
	private String matricula;


	public Usuario(Cargo cargo, String nome, String senha, LocalDate nascimento) {
		this.cargo = cargo;
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

	public Cargo getFuncao() {
		return cargo;
	}

	public void setFuncao(Cargo cargo) {
		this.cargo = cargo;
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

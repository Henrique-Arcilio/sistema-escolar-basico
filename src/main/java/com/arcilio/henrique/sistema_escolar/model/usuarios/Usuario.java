package com.arcilio.henrique.sistema_escolar.model.usuarios;

import java.time.LocalDate;

import com.arcilio.henrique.sistema_escolar.model.categorias.Funcao;

public abstract class Usuario {
	
	private Funcao funcao;
	private String nome;
	private LocalDate idade;
	private String matricula;
	private String senha;

	public Usuario(Funcao funcao, String nome, LocalDate idade, String matricula, String senha) {
		this.funcao = funcao;
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getIdade() {
		return idade;
	}
	public void setIdade(LocalDate idade) {
		this.idade = idade;
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

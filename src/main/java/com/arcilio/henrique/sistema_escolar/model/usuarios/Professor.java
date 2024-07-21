package com.arcilio.henrique.sistema_escolar.model.usuarios;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.arcilio.henrique.sistema_escolar.model.categorias.Funcao;
import com.arcilio.henrique.sistema_escolar.model.categorias.Disciplina;

public class Professor extends Usuario implements Funcionario {
	private BigDecimal salario;
	private Disciplina disciplina;
	
	public Professor(Funcao funcao, String nome, LocalDate idade, 
					String matricula, String senha,
					BigDecimal salario, Disciplina disciplina) {
		
		super(funcao, nome, idade, matricula, senha);
		this.salario = salario;
		this.disciplina = disciplina;
		
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	@Override
	//Lógica para fazer
	public BigDecimal receberSalario() {
		return null;
	}
}

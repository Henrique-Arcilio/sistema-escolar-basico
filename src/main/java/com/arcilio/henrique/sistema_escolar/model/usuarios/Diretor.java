package com.arcilio.henrique.sistema_escolar.model.usuarios;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.arcilio.henrique.sistema_escolar.model.categorias.Funcao;

public class Diretor extends Usuario implements Funcionario{
	private BigDecimal salario;

	public Diretor(Funcao funcao, String nome, String senha,
				   LocalDate nascimento, BigDecimal salario) {
		
		super(funcao, nome,senha, nascimento);
		this.salario = salario;
		
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

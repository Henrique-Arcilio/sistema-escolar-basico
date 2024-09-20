package com.arcilio.henrique.sistema_escolar.model.usuarios;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.arcilio.henrique.sistema_escolar.model.categorias.Cargo;

public class Diretor extends Usuario implements Funcionario{
	private BigDecimal salario;

	public Diretor(Cargo cargo, String nome, String senha,
                   LocalDate nascimento, BigDecimal salario) {
		
		super(cargo, nome,senha, nascimento);
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

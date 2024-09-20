package com.arcilio.henrique.sistema_escolar.model.usuarios;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.arcilio.henrique.sistema_escolar.model.Turma;
import com.arcilio.henrique.sistema_escolar.model.categorias.Cargo;

public class Aluno extends Usuario {
	private Turma turma;
	private BigDecimal[] notas;
	private BigDecimal mediaFinal;
	
	
	public Aluno(Cargo cargo, String nome, String senha,
                 LocalDate nascimento, Turma turma) {
		
		super(cargo, nome, senha, nascimento);
		this.turma = turma;
		this.notas = new BigDecimal[3];
		this.mediaFinal = new BigDecimal(0);
		
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public BigDecimal[] getNotas() {
		return notas;
	}
	public void setNotas(BigDecimal[] notas) {
		this.notas = notas;
	}
	public BigDecimal getMediaFinal() {
		return mediaFinal;
	}
	public void setMediaFinal(BigDecimal mediaFinal) {
		this.mediaFinal = mediaFinal;
	}
	
	
	
}

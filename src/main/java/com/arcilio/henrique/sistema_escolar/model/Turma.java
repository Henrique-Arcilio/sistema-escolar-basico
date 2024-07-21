package com.arcilio.henrique.sistema_escolar.model;

import java.util.ArrayList;

import com.arcilio.henrique.sistema_escolar.model.categorias.Turno;
import com.arcilio.henrique.sistema_escolar.model.usuarios.Aluno;

public class Turma {
	
	private String serie;
	private Turno turno;
	private ArrayList<Aluno> alunos;
	
	public Turma (String serie, Turno turno) {
		this.serie = serie;
		this.turno = turno;
		this.alunos = new ArrayList<>();
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
}

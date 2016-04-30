package br.com.tt.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Turma implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId	
	private TurmaPK id;	
	private Integer qtd;	
	private String Professor;
	public TurmaPK getId() {
		return id;
	}
	public void setId(TurmaPK id) {
		this.id = id;
	}
	public Integer getQtd() {
		return qtd;
	}
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	public String getProfessor() {
		return Professor;
	}
	public void setProfessor(String professor) {
		Professor = professor;
	}	
	
	
}

package br.com.tt.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the turmas database table.
 * 
 */
@Embeddable
public class TurmaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private Integer ano;

	@Column(unique=true, nullable=false)
	private Integer semestre;

	@Column(name="cod_disc", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer codDisc;

	@Column(unique=true, nullable=false, length=3)
	private String turma;

	public TurmaPK() {
	}
	public Integer getAno() {
		return this.ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getSemestre() {
		return this.semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public Integer getCodDisc() {
		return this.codDisc;
	}
	public void setCodDisc(Integer codDisc) {
		this.codDisc = codDisc;
	}
	public String getTurma() {
		return this.turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TurmaPK)) {
			return false;
		}
		TurmaPK castOther = (TurmaPK)other;
		return 
			this.ano.equals(castOther.ano)
			&& this.semestre.equals(castOther.semestre)
			&& this.codDisc.equals(castOther.codDisc)
			&& this.turma.equals(castOther.turma);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ano.hashCode();
		hash = hash * prime + this.semestre.hashCode();
		hash = hash * prime + this.codDisc.hashCode();
		hash = hash * prime + this.turma.hashCode();
		
		return hash;
	}
}
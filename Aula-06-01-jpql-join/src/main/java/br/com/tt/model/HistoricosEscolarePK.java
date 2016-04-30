package br.com.tt.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the historicos_escolares database table.
 * 
 */
@Embeddable
public class HistoricosEscolarePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private Integer ano;

	@Column(unique=true, nullable=false)
	private Integer semestre;

	@Column(name="cod_disc", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer codDisc;

	@Column(name="mat_alu", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer matAlu;

	public HistoricosEscolarePK() {
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
	public Integer getMatAlu() {
		return this.matAlu;
	}
	public void setMatAlu(Integer matAlu) {
		this.matAlu = matAlu;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HistoricosEscolarePK)) {
			return false;
		}
		HistoricosEscolarePK castOther = (HistoricosEscolarePK)other;
		return 
			this.ano.equals(castOther.ano)
			&& this.semestre.equals(castOther.semestre)
			&& this.codDisc.equals(castOther.codDisc)
			&& this.matAlu.equals(castOther.matAlu);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ano.hashCode();
		hash = hash * prime + this.semestre.hashCode();
		hash = hash * prime + this.codDisc.hashCode();
		hash = hash * prime + this.matAlu.hashCode();
		
		return hash;
	}
}
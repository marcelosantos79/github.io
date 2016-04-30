package br.com.tt.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the conceitos database table.
 * 
 */
@Entity
@Table(name="conceitos")
@NamedQuery(name="Conceito.findAll", query="SELECT c FROM Conceito c")
public class Conceito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONCEITOS_CONCEITO_GENERATOR", sequenceName="CONCEITO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONCEITOS_CONCEITO_GENERATOR")
	@Column(unique=true, nullable=false, length=1)
	private String conceito;

	@Column(name="faixa_fim", nullable=false)
	private double faixaFim;

	@Column(name="faixa_ini", nullable=false)
	private double faixaIni;

	public Conceito() {
	}

	public String getConceito() {
		return this.conceito;
	}

	public void setConceito(String conceito) {
		this.conceito = conceito;
	}

	public double getFaixaFim() {
		return this.faixaFim;
	}

	public void setFaixaFim(double faixaFim) {
		this.faixaFim = faixaFim;
	}

	public double getFaixaIni() {
		return this.faixaIni;
	}

	public void setFaixaIni(double faixaIni) {
		this.faixaIni = faixaIni;
	}

}
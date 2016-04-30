package br.com.tt.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the historicos_escolares database table.
 * 
 */
@Entity
@Table(name="historicos_escolares")
@NamedQuery(name="HistoricosEscolare.findAll", query="SELECT h FROM HistoricosEscolare h")
public class HistoricosEscolare implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HistoricosEscolarePK id;

	@Column(nullable=false)
	private double faltas;

	@Column(nullable=false)
	private double media;

	@Column(nullable=false, length=2)
	private String situacao;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="mat_alu", nullable=false, insertable=false, updatable=false)
	private Aluno aluno;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="cod_disc", nullable=false, insertable=false, updatable=false)
	private Disciplina disciplina;

	public HistoricosEscolare() {
	}

	public HistoricosEscolarePK getId() {
		return this.id;
	}

	public void setId(HistoricosEscolarePK id) {
		this.id = id;
	}

	public double getFaltas() {
		return this.faltas;
	}

	public void setFaltas(double faltas) {
		this.faltas = faltas;
	}

	public double getMedia() {
		return this.media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
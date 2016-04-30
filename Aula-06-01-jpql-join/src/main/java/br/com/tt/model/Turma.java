package br.com.tt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the turmas database table.
 * 
 */
@Entity
@Table(name="turmas")
@NamedQuery(name="Turma.findAll", query="SELECT t FROM Turma t")
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TurmaPK id;

	@Column(name="tot_vagas", nullable=false)
	private Integer totVagas;

	@Column(name="vag_ocup", nullable=false)
	private Integer vagOcup;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="cod_disc", nullable=false, insertable=false, updatable=false)
	private Disciplina disciplina;

	//bi-directional many-to-one association to Professore
	@ManyToOne
	@JoinColumn(name="cod_prof")
	private Professore professore;

	//bi-directional many-to-one association to TurmasMatriculada
	@OneToMany(mappedBy="turmaBean")
	private List<TurmasMatriculada> turmasMatriculadas;

	public Turma() {
	}

	public TurmaPK getId() {
		return this.id;
	}

	public void setId(TurmaPK id) {
		this.id = id;
	}

	public Integer getTotVagas() {
		return this.totVagas;
	}

	public void setTotVagas(Integer totVagas) {
		this.totVagas = totVagas;
	}

	public Integer getVagOcup() {
		return this.vagOcup;
	}

	public void setVagOcup(Integer vagOcup) {
		this.vagOcup = vagOcup;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professore getProfessore() {
		return this.professore;
	}

	public void setProfessore(Professore professore) {
		this.professore = professore;
	}

	public List<TurmasMatriculada> getTurmasMatriculadas() {
		return this.turmasMatriculadas;
	}

	public void setTurmasMatriculadas(List<TurmasMatriculada> turmasMatriculadas) {
		this.turmasMatriculadas = turmasMatriculadas;
	}

	public TurmasMatriculada addTurmasMatriculada(TurmasMatriculada turmasMatriculada) {
		getTurmasMatriculadas().add(turmasMatriculada);
		turmasMatriculada.setTurmaBean(this);

		return turmasMatriculada;
	}

	public TurmasMatriculada removeTurmasMatriculada(TurmasMatriculada turmasMatriculada) {
		getTurmasMatriculadas().remove(turmasMatriculada);
		turmasMatriculada.setTurmaBean(null);

		return turmasMatriculada;
	}

}
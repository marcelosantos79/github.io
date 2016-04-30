package br.com.tt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the professores database table.
 * 
 */
@Entity
@Table(name="professores")
@NamedQuery(name="Professore.findAll", query="SELECT p FROM Professore p")
public class Professore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROFESSORES_CODPROF_GENERATOR", sequenceName="PROFESSORES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFESSORES_CODPROF_GENERATOR")
	@Column(name="cod_prof", unique=true, nullable=false)
	private Integer codProf;

	@Column(length=30)
	private String email;

	@Column(name="nom_prof", nullable=false, length=60)
	private String nomProf;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="professore")
	private List<Curso> cursos;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="cod_curso", nullable=false)
	private Curso curso;

	//bi-directional many-to-one association to Turma
	@OneToMany(mappedBy="professore")
	private List<Turma> turmas;

	public Professore() {
	}

	public Integer getCodProf() {
		return this.codProf;
	}

	public void setCodProf(Integer codProf) {
		this.codProf = codProf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomProf() {
		return this.nomProf;
	}

	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setProfessore(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setProfessore(null);

		return curso;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setProfessore(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setProfessore(null);

		return turma;
	}

}
package br.com.tt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cursos database table.
 * 
 */
@Entity
@Table(name="cursos")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CURSOS_CODCURSO_GENERATOR", sequenceName="CURSOS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CURSOS_CODCURSO_GENERATOR")
	@Column(name="cod_curso", unique=true, nullable=false)
	private Integer codCurso;

	@Column(name="nom_curso", nullable=false, length=60)
	private String nomCurso;

	@Column(name="tot_cred", nullable=false)
	private Integer totCred;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="curso")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to Curriculo
	@OneToMany(mappedBy="curso")
	private List<Curriculo> curriculos;

	//bi-directional many-to-one association to Professore
	@ManyToOne
	@JoinColumn(name="cod_coord")
	private Professore professore;

	//bi-directional many-to-one association to Professore
	@OneToMany(mappedBy="curso")
	private List<Professore> professores;

	public Curso() {
	}

	public Integer getCodCurso() {
		return this.codCurso;
	}

	public void setCodCurso(Integer codCurso) {
		this.codCurso = codCurso;
	}

	public String getNomCurso() {
		return this.nomCurso;
	}

	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}

	public Integer getTotCred() {
		return this.totCred;
	}

	public void setTotCred(Integer totCred) {
		this.totCred = totCred;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setCurso(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setCurso(null);

		return aluno;
	}

	public List<Curriculo> getCurriculos() {
		return this.curriculos;
	}

	public void setCurriculos(List<Curriculo> curriculos) {
		this.curriculos = curriculos;
	}

	public Curriculo addCurriculo(Curriculo curriculo) {
		getCurriculos().add(curriculo);
		curriculo.setCurso(this);

		return curriculo;
	}

	public Curriculo removeCurriculo(Curriculo curriculo) {
		getCurriculos().remove(curriculo);
		curriculo.setCurso(null);

		return curriculo;
	}

	public Professore getProfessore() {
		return this.professore;
	}

	public void setProfessore(Professore professore) {
		this.professore = professore;
	}

	public List<Professore> getProfessores() {
		return this.professores;
	}

	public void setProfessores(List<Professore> professores) {
		this.professores = professores;
	}

	public Professore addProfessore(Professore professore) {
		getProfessores().add(professore);
		professore.setCurso(this);

		return professore;
	}

	public Professore removeProfessore(Professore professore) {
		getProfessores().remove(professore);
		professore.setCurso(null);

		return professore;
	}

	@Override
	public String toString() {
		return "Curso [codCurso=" + codCurso + ", nomCurso=" + nomCurso + ", totCred=" + totCred + ", alunos=" + alunos
				+ ", curriculos=" + curriculos + ", professore=" + professore + ", professores=" + professores + "]";
	}
	
	

}
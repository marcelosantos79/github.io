package br.com.tt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the alunos database table.
 * 
 */
@Entity
@Table(name="alunos")
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ALUNOS_MATALU_GENERATOR", sequenceName="ALUNO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALUNOS_MATALU_GENERATOR")
	@Column(name="mat_alu", unique=true, nullable=false)
	private Integer matAlu;

	@Temporal(TemporalType.DATE)
	@Column(name="dat_nasc", nullable=false)
	private Date datNasc;

	@Column(length=30)
	private String email;

	@Column(nullable=false)
	private double mgp;

	@Column(name="nom_alu", nullable=false, length=60)
	private String nomAlu;

	@Column(name="tot_cred", nullable=false)
	private Integer totCred;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="cod_curso", nullable=false)
	private Curso curso;

	//bi-directional many-to-one association to HistoricosEscolare
	@OneToMany(mappedBy="aluno")
	private List<HistoricosEscolare> historicosEscolares;

	//bi-directional many-to-one association to TurmasMatriculada
	@OneToMany(mappedBy="aluno")
	private List<TurmasMatriculada> turmasMatriculadas;

	public Aluno() {
	}

	public Integer getMatAlu() {
		return this.matAlu;
	}

	public void setMatAlu(Integer matAlu) {
		this.matAlu = matAlu;
	}

	public Date getDatNasc() {
		return this.datNasc;
	}

	public void setDatNasc(Date datNasc) {
		this.datNasc = datNasc;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getMgp() {
		return this.mgp;
	}

	public void setMgp(double mgp) {
		this.mgp = mgp;
	}

	public String getNomAlu() {
		return this.nomAlu;
	}

	public void setNomAlu(String nomAlu) {
		this.nomAlu = nomAlu;
	}

	public Integer getTotCred() {
		return this.totCred;
	}

	public void setTotCred(Integer totCred) {
		this.totCred = totCred;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<HistoricosEscolare> getHistoricosEscolares() {
		return this.historicosEscolares;
	}

	public void setHistoricosEscolares(List<HistoricosEscolare> historicosEscolares) {
		this.historicosEscolares = historicosEscolares;
	}

	public HistoricosEscolare addHistoricosEscolare(HistoricosEscolare historicosEscolare) {
		getHistoricosEscolares().add(historicosEscolare);
		historicosEscolare.setAluno(this);

		return historicosEscolare;
	}

	public HistoricosEscolare removeHistoricosEscolare(HistoricosEscolare historicosEscolare) {
		getHistoricosEscolares().remove(historicosEscolare);
		historicosEscolare.setAluno(null);

		return historicosEscolare;
	}

	public List<TurmasMatriculada> getTurmasMatriculadas() {
		return this.turmasMatriculadas;
	}

	public void setTurmasMatriculadas(List<TurmasMatriculada> turmasMatriculadas) {
		this.turmasMatriculadas = turmasMatriculadas;
	}

	public TurmasMatriculada addTurmasMatriculada(TurmasMatriculada turmasMatriculada) {
		getTurmasMatriculadas().add(turmasMatriculada);
		turmasMatriculada.setAluno(this);

		return turmasMatriculada;
	}

	public TurmasMatriculada removeTurmasMatriculada(TurmasMatriculada turmasMatriculada) {
		getTurmasMatriculadas().remove(turmasMatriculada);
		turmasMatriculada.setAluno(null);

		return turmasMatriculada;
	}

}
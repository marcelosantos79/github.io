package br.com.tt.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the turmas_matriculadas database table.
 * 
 */
@Entity
@Table(name="turmas_matriculadas")
@NamedQuery(name="TurmasMatriculada.findAll", query="SELECT t FROM TurmasMatriculada t")
public class TurmasMatriculada implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TurmasMatriculadaPK id;

	@Column(name="faltas_1")
	private Integer faltas1;

	@Column(name="faltas_2")
	private Integer faltas2;

	@Column(name="faltas_3")
	private Integer faltas3;

	@Column(name="nota_1")
	private double nota1;

	@Column(name="nota_2")
	private double nota2;

	@Column(name="nota_3")
	private double nota3;

	@Column(name="nota_4")
	private double nota4;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="mat_alu", nullable=false, insertable=false, updatable=false)
	private Aluno aluno;

	//bi-directional many-to-one association to Turma
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ano", referencedColumnName="ano", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="cod_disc", referencedColumnName="cod_disc", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="semestre", referencedColumnName="semestre", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="turma", referencedColumnName="turma", nullable=false)
		})
	private transient Turma turmaBean;

	public TurmasMatriculada() {
	}

	public TurmasMatriculadaPK getId() {
		return this.id;
	}

	public void setId(TurmasMatriculadaPK id) {
		this.id = id;
	}

	public Integer getFaltas1() {
		return this.faltas1;
	}

	public void setFaltas1(Integer faltas1) {
		this.faltas1 = faltas1;
	}

	public Integer getFaltas2() {
		return this.faltas2;
	}

	public void setFaltas2(Integer faltas2) {
		this.faltas2 = faltas2;
	}

	public Integer getFaltas3() {
		return this.faltas3;
	}

	public void setFaltas3(Integer faltas3) {
		this.faltas3 = faltas3;
	}

	public double getNota1() {
		return this.nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return this.nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return this.nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public double getNota4() {
		return this.nota4;
	}

	public void setNota4(double nota4) {
		this.nota4 = nota4;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurmaBean() {
		return this.turmaBean;
	}

	public void setTurmaBean(Turma turmaBean) {
		this.turmaBean = turmaBean;
	}

}
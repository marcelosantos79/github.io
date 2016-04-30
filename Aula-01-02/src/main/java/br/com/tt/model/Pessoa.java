package br.com.tt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
//@Table(name="T_PESSOAS", uniqueConstraints = @UniqueConstraint(columnNames={"nome"}))
//@Table(name="T_PESSOAS")

public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(
			name="pessoa_seq", 
			sequenceName="pessoa_seq",
			allocationSize=1)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator="pessoa_seq")
	
	private Long id;
	
	@Column(length = 11, nullable = false, unique = true, updatable = false)
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private Endereco endereco;
	private Empresa empresa;
	@Column(name = "sexo")
	private TipoSexo tipoSexo;
	
	
	public Pessoa() {
		super();
	}
	

	public Pessoa(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}
	public void setTipoSexo(TipoSexo tipoSexo) {
		this.tipoSexo = tipoSexo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}			 
}

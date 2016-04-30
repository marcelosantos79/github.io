package br.com.tt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = Cliente.SQL_ALL, query = "SELECT c FROM Cliente c"),				
				@NamedQuery(name = Cliente.SQL_NOME, query = "SELECT c FROM Cliente c WHERE c.nome = :nome "),})

public class Cliente implements Serializable{
	
	public static final String CONSULTAR_NOME = "SELECT c FROM Cliente c WHERE c.nome = :Nome";
	public static final String SQL_ALL = "Cliente.SQL_ALL";
	public static final String SQL_NOME = "Cliente.SQL_NOME";
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pessoa_seq", sequenceName="", allocationSize=1)
	@GeneratedValue(generator="pessoa_seq", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	@Column(length = 11)
	private String cpf;
	private String rg;
	@Temporal(TemporalType.DATE)
	@Column(name="data_nasc")
	private Date datanasc;
	
	
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
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", datanasc=" + datanasc + "]";
	}
	
}

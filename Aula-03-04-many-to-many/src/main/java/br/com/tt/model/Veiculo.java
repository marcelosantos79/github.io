package br.com.tt.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="veiculo_seq", sequenceName="veiculo_seq", allocationSize=1)	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo_seq")
	private Long id;
	private String placa;
	
	private List<Infracaos> infracoes;
	
}

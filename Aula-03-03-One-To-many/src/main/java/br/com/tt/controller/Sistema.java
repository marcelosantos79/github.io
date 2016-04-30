package br.com.tt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.tt.model.Cliente;
import br.com.tt.model.Telefone;
import br.com.tt.model.TelefoneType;

public class Sistema {
	public static void main(String[] args) {

EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
	
	EntityTransaction transaction = em.getTransaction();
	transaction.begin();
	Cliente cliente = new Cliente();
	cliente.setNome("Marcelo");

	Telefone telefone1 = new Telefone();	
	telefone1.setDdd("51");
	telefone1.setNumero("99999");
	telefone1.setCliente(cliente);
	telefone1.setTelefoneType(TelefoneType.CELULAR);
	cliente.addTelefone(telefone1);
	
	Telefone telefone2 = new Telefone();
	telefone2.setDdd("41");
	telefone2.setNumero("77777");
	telefone2.setTelefoneType(TelefoneType.COMERCIAL);
	telefone2.setCliente(cliente);
	cliente.addTelefone(telefone2);
	
	em.persist(cliente);	
	em.getTransaction().commit();
	System.exit(0);	
	}
}

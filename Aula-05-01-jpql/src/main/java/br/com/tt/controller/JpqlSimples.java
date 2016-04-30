package br.com.tt.controller;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import static java.lang.System.out;

import br.com.tt.model.Cliente;

public class JpqlSimples {

	public static void main(String[] args) {
		/*

		salvarCliente();
		salvarCliente();
		salvarCliente();
		salvarCliente();
		*/
		EntityManager em = getEm();
		String sql = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> query = em.createQuery(sql, Cliente.class);
		List<Cliente> resultList = query.getResultList();
		em.createQuery(sql, Cliente.class);
		
				
		resultList.forEach(c-> out.println(c));

		System.exit(0);
	}
	
	private static EntityManager getEm(){
		return Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
	}
	
	private static void salvarCliente(){	
		Cliente cliente = new Cliente();		
		cliente.setNome("Pedro");
		cliente.setCpf("12345678901");
		cliente.setRg("4578945");
		Calendar data = Calendar.getInstance();
		data.set(2016, Calendar.APRIL, 27);
		cliente.setDatanasc(data.getTime());
		
		EntityManager em = getEm();
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();		
		em.close();
	}
}

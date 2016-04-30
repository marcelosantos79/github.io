package br.com.tt.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import static java.lang.System.out;

import br.com.tt.model.Cliente;

public class JpqlConsultaComParametro {
	public static void main(String[] args) {
		
		EntityManager em = getEm();
		TypedQuery<Cliente> query = em.createQuery(Cliente.CONSULTAR_NOME , Cliente.class);
		query.setParameter("Nome", "Marcelo");
		List<Cliente> resultList = query.getResultList();
		resultList.forEach(c->out.print(c));		
	}
	
	
	private static EntityManager getEm(){
		return Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
	}

}

package br.com.tt.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import static java.lang.System.out;

import br.com.tt.model.Cliente;

public class JpqlConsultaComConstante {
	public static void main(String[] args) {

		EntityManager em = getEm();
		String sql = "SELECT c FROM Cliente c WHERE c.nome = :Nome";
		TypedQuery<Cliente> query = em.createQuery(sql, Cliente.class);
		query.setParameter("Nome", "Marcelo");
		List<Cliente> resultList = query.getResultList();
		resultList.forEach(c->out.print(c));
		
	}
	
	
	
	private static EntityManager getEm(){
		return Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
	}

}

package br.com.tt.controller;

import static java.lang.System.out;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.model.Cliente;

public class Jpql04Limit {

	public static void main(String[] args) {
		EntityManager em = getEm();
		String sql = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> query = em.createQuery(sql, Cliente.class);
		query.setFirstResult(1);
		query.setMaxResults(3);
		
		List<Cliente> resultList = query.getResultList();
		resultList.forEach(c-> out.println(c));
		System.exit(0);

	}

	private static EntityManager getEm(){
		return Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
	}

	
}

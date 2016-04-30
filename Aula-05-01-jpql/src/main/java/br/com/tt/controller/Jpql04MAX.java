package br.com.tt.controller;

import static java.lang.System.out;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.model.Cliente;

public class Jpql04MAX {

	public static void main(String[] args) {
		
		EntityManager em = getEm();
		String sql = "SELECT MAX(c.id) FROM Cliente c";
		TypedQuery<Long> query = em.createQuery(sql, Long.class);
		
		Long result = query.getSingleResult();
		out.println(result);
		System.exit(0);

	}

	private static EntityManager getEm(){
		return Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
	}

	
}

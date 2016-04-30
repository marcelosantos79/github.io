package br.com.tt.controller;

import static java.lang.System.out;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.model.Cliente;

public class Jpql08Distinct {

	public static void main(String[] args) {
		
		EntityManager em = getEm();
		Class<Cliente> clazz = Cliente.class;
		
		String nomeDigitado = "    Marcelo   ";
		
		String sql = "SELECT DISTINCT c FROM Cliente c ";

		TypedQuery<Cliente> query = em.createQuery(sql, clazz);
	
		List<Cliente> clientes = query.getResultList();
		clientes.forEach(c -> out.println(c));
			
		System.exit(0);

	}

	private static EntityManager getEm(){
		return Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
	}

	
}

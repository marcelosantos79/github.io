package br.com.tt.controller;

import static java.lang.System.out;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.model.Cliente;
import br.com.tt.vo.ClienteVO;

public class Jpql09RelatorioNewVo {

	public static void main(String[] args) {
		
		EntityManager em = getEm();
		Class<ClienteVO> clazz = ClienteVO.class;
	
		String sql = "SELECT ";
		sql += " New br.com.tt.vo.ClienteVO( ";
		sql += " c.nome, c.cpf)              ";
		sql += " FROM Cliente c "             ;

		TypedQuery<ClienteVO> query = em.createQuery(sql, clazz);
	
		List<ClienteVO> clientes = query.getResultList();
		clientes.forEach(c -> out.println(c));
			
		System.exit(0);

	}

	private static EntityManager getEm(){
		return Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
	}

	
}

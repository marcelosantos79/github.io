/**
 * 
 */
package br.com.tt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.model.Pessoa;
import br.com.tt.model.TipoSexo;

/**
 * @author sala03
 *
 */
public class Sistema {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_jpa");		
		EntityManager em = emf.createEntityManager();
		System.out.println("Entity manager está : " + em.isOpen());		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Maria das Dores");
		pessoa.setTipoSexo(TipoSexo.FEMININO);
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();		
	}
}

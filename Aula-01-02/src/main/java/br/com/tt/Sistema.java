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
		try{
		System.out.println("Entity manager está : " + em.isOpen());		
		Pessoa pessoa = new Pessoa();

		pessoa.setNome("Maria das Dores");
		pessoa.setTipoSexo(TipoSexo.FEMININO);
		pessoa.setCpf("123123123123");
		
		new Pessoa("11223344551", "Marcelo");
		new Pessoa("11225454551", "Marcell");
		
		em.getTransaction().begin();			
		em.persist(pessoa);
		em.getTransaction().commit();
		}catch(Exception e){
			
		System.out.println("Erro no Banco");	
		e.printStackTrace();
		}finally {
			if (em != null){
				em.clear();
				em.close();
				emf.close();
				}			
		}
	}
}

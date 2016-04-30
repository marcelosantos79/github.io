package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.secure.spi.PermissibleAction;

import br.com.tt.model.Endereco;
import br.com.tt.model.Pessoa;

public class Sistema {
public static void main(String[] args) {
	
	EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
	
	EntityTransaction transaction = em.getTransaction();
	transaction.begin();
	Endereco endereco = getEndereco();
	Pessoa pessoa = getPessoa();
	pessoa.setEndereco(endereco);
	em.persist(pessoa);
	//em.persist(endereco);
	em.getTransaction().commit();
	System.exit(0);			
}

private static Endereco getEndereco() {
	Endereco endereco = new Endereco();
	endereco.setRua("Alfredo");
	endereco.setCep("96745000");
	return endereco;
}

private static Pessoa getPessoa() {
	Pessoa pessoa = new Pessoa();
	pessoa.setNome("Marcelo");
	pessoa.setCpf("123456123");
	//pessoa.setDataNasc('27-11-1979');
	return pessoa;
}
}

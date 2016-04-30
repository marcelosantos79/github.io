package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.tt.model.Turma;
import br.com.tt.model.TurmaPK;

public class Sistema {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa").createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		TurmaPK turmaPk = new TurmaPK();
		
		turmaPk.setCurso("JPA");
		turmaPk.setMes("Abril");
		turmaPk.setTurno("Noite");

		Turma turma = new Turma();
		turma.setId(turmaPk);
		turma.setProfessor("Paulo");
		turma.setQtd(5);
		em.persist(turma);
		System.out.println(em.find(Turma.class, turmaPk));
		transaction.commit();
		System.exit(0);		

	}

}

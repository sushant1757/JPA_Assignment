package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AuthorOp {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Author ath = new Author();
		
		ath.setFirstName("Sushant");
		ath.setMiddleName("H");
		ath.setLastName("Gadekar");
		ath.setPhoneNo(9970);
		
		em.persist(ath);

		System.out.println("Added Author to database.");
		em.getTransaction().commit();
		
		int id = 3;
		 Author athh = em.find(Author.class, id);
		 athh.setPhoneNo(1945);
		 em.getTransaction().begin();
		 em.merge(athh);
		 em.getTransaction().commit();
		 System.out.println("Updated to database.");
		
		em.close();
		factory.close();
	}

}

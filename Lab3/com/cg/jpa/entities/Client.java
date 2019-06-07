package com.cg.jpa.entities;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Client {

public static void main(String[] args) {

 EntityManagerFactory factory = Persistence
   .createEntityManagerFactory("JPA-PU");
 EntityManager em = factory.createEntityManager();
 EntityTransaction transaction = em.getTransaction();
 transaction.begin();

 // first define few books

 Book bk = new Book();
 bk.setId(1);
 bk.setTitle("ABC");
 bk.setPrice(20);

 Book bk1 = new Book();
 bk1.setId(2);
 bk1.setTitle("PQR");
 bk1.setPrice(25);

 Book bk2 = new Book();
 bk2.setId(3);
 bk2.setTitle("MNO");
 bk2.setPrice(30);

 // now define first order and add few products in it
 Author auth = new Author();
 auth.setId(101);
 auth.setTitle("A");

 auth.addBook(bk);
 auth.addBook(bk1);
 auth.addBook(bk2);

 // now define second order and add few products in it
 Author auth2 = new Author();
 auth2.setId(102);
 auth2.setTitle("B");

 auth2.addBook(bk);
 auth2.addBook(bk1);
 auth2.addBook(bk2);

 // save orders using entity manager

 em.persist(auth);
 em.persist(auth2);

 System.out.println("Added books along with author details to database.");

 transaction.commit();
 em.close();
 factory.close();
}
}

package com.epam.dao;


import com.epam.entity.*;
import javax.persistence.*;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class InstructorDAO implements InstructorDAOInterface{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-local-mysql");

	
	public List<Instructor> getAllInstructor()
	{
		EntityManager em = emf.createEntityManager();
		Query query=em.createQuery("from Instructor i");
		System.out.println(query.getResultList());
		return query.getResultList();
		
	}
	
	public void save(Instructor instructor)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(instructor);
		em.getTransaction().commit();
		em.close();
	}



	
	
	

}

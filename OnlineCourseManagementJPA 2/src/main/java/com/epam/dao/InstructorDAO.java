package com.epam.dao;


import com.epam.entity.*;
import javax.persistence.*;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class InstructorDAO implements InstructorDAOInterface{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-local-mysql");

	EntityManager em = emf.createEntityManager();
	public List<Instructor> getAllInstructor()
	{
		Query query=em.createQuery("from Instructor i");
		System.out.println(query.getResultList());
		return query.getResultList();
	}
	
	public void add(Instructor instructor)
	{
		em.getTransaction().begin();
		em.persist(instructor);
		em.getTransaction().commit();
	}



	
	
	

}

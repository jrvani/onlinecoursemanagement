package com.epam.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.epam.dto.InstructorDTO;
import com.epam.entity.Instructor;
import com.epam.model_mapper.ModelMapperService;
import com.epam.utility.EntityManagerUtil;


@Repository
public class InstructorDAOImpl implements InstructorDAO{

	EntityManagerFactory emf = EntityManagerUtil.getFactory();

	
	public List<Instructor> getAllInstructor()
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Instructor> query=em.createQuery("from Instructor i",Instructor.class);
		List<Instructor> list=query.getResultList();
		em.close();
		return list;
		
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

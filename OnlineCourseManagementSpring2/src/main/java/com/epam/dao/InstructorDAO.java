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
public class InstructorDAO implements InstructorDAOInterface{

	EntityManagerFactory emf = EntityManagerUtil.getFactory();

	
	public List<Instructor> getAllInstructor()
	{
		EntityManager em = emf.createEntityManager();
		TypedQuery<Instructor> query=em.createQuery("from Instructor i",Instructor.class);
		List<Instructor> list=query.getResultList();
		em.close();
		return list;
		
	}
	
	public void save(InstructorDTO instructorDto)
	{
		Instructor instructor=	ModelMapperService.convertDtoToInsEntity(instructorDto);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(instructor);
		em.getTransaction().commit();
		em.close();
		
	}



	
	
	

}

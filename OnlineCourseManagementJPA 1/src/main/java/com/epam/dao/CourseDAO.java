package com.epam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

import com.epam.entity.Course;
import com.epam.entity.Instructor;
import com.epam.service.EmptyFieldException;



public class CourseDAO {
	
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-local-mysql");
	 EntityManager em = emf.createEntityManager();
	
	public  void add(Course course)
	{
		em.getTransaction().begin();
		em.persist(course);
		em.getTransaction().commit();
		
	}
	public void delete(int id, String courseName)
	{
		Course course=null;
		Query query=em.createQuery("select c from Course c where instructor_instructor_id="+id);
		List<Course> list=query.getResultList();
	    for(Course c:list)
	    {
	    	if(c.getCourseName().equals(courseName))
	    	{
	    		course=c;
	    		break;
	    	}
	    }
		em.getTransaction().begin();
		em.remove(course);
		em.getTransaction().commit();
		
		
	}
	public List<Course> view(int id)
	{
		
		Query query=em.createQuery("select c from Course c where instructor_instructor_id="+id);
		List<Course> list=query.getResultList();
		return list;
		
	}
	
	


}


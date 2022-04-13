package com.epam.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.epam.entity.Course;
import com.epam.entity.Instructor;
import com.epam.service.EmptyFieldException;
import com.google.protobuf.UInt32Value;



public class CourseDAO implements CourseDAOInterface{
	
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-local-mysql");
	
	public void add(Course course)
	{
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(course);
		em.getTransaction().commit();
		em.close();
		
		
	}
	public void delete(int id,String courseName)
	{
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Query query=em.createQuery("DELETE FROM Course WHERE  instructor_instructor_id=:id and course_name=:courseName");
		query.setParameter("id",id);
		query.setParameter("courseName", courseName);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
	}
	public List<Course> view(int id)
	{
		EntityManager em = emf.createEntityManager();
		Query query=em.createQuery("select c from Course c where instructor_instructor_id="+id);
		List<Course> list=query.getResultList();
		return list;
		
	}
	

}


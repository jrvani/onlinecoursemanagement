package com.epam.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.epam.entity.Course;
import com.epam.entity.Instructor;
import com.epam.utility.EntityManagerUtil;

@Repository
public class CourseDAO implements CourseDAOInterface{
	
	 EntityManagerFactory emf = EntityManagerUtil.getFactory();
	 
	 public Instructor find(int id)
	 {
		 EntityManager em = emf.createEntityManager();
		 Instructor instructor=em.find(Instructor.class, id);
		em.close();
	
		 return instructor;
	 }
	public List<Course> getAll()
	{
		EntityManager em = emf.createEntityManager();
		TypedQuery<Course> query=em.createQuery("Select c from Course", Course.class);
		
		List<Course> list=query.getResultList();
		em.close();
		return list;
	}
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
		Query query=em.createQuery("DELETE FROM Course c WHERE instructor_instructor_id=:id AND course_name=:courseName");
		query.setParameter("id", id);
		query.setParameter("courseName", courseName);
		
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
	}
	public List<Course> view(int id)
	{
		EntityManager em = emf.createEntityManager();
		TypedQuery<Course> query= em.createQuery("select c from Course c where instructor_instructor_id=:id",Course.class);
		query.setParameter("id",id);
		
		List<Course> list=query.getResultList();
		
		return list;
		
	}
	

}


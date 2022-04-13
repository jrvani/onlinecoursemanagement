package com.epam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.utility.EntityManagerUtil;

public class AssignmentDAO implements AssignmentDAOInterface {
	
	EntityManagerUtil entityManagerUtil=new EntityManagerUtil();
	EntityManagerFactory emf=entityManagerUtil.getFactory();
	public Course getCourse(int id,String courseName)
	{
		EntityManager em = emf.createEntityManager();
		TypedQuery<Course> query=em.createQuery("select c from Course c where instructor_instructor_id=:id AND course_name=:courseName",Course.class);
		query.setParameter("id", id);
		query.setParameter("courseName",courseName);
		List<Course> list=query.getResultList();
		
	   return list.get(0);
	   
	}
	
	public Assignment add(Assignment assignment)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(assignment);
		em.getTransaction().commit();
		
		return assignment;
		
	}
	public void delete(Assignment assignment)
	{
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		em.remove(assignment);
		em.getTransaction().commit();
		em.close();
		
		
		
	}
	public List<Assignment> view(Course c)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		return c.getAssignments();
		
		
	}
	
	
	
	
	


}

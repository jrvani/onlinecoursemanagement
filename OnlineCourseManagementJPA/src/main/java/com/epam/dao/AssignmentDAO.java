package com.epam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.epam.entity.Assignment;
import com.epam.entity.Course;
import com.epam.utility.EntityManagerUtil;

public class AssignmentDAO implements AssignmentDAOInterface {
	
	EntityManagerFactory emf=EntityManagerUtil.getFactory();
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
	public void delete(int id)
	{
		EntityManager em = emf.createEntityManager();
		Query query=em.createQuery("delete from Assignment where assignment_id=:id");
        query.setParameter("id", id);
		
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
		
		
	}
	public List<Assignment> view(Course c)
	{
		EntityManager em = emf.createEntityManager();
		TypedQuery<Assignment> query=em.createQuery("select a from Assignment a where course_cid=:id",Assignment.class);
		query.setParameter("id",c.getCourseId());
		
	
		
		return query.getResultList();
		
		
	}
	
	
	
	
	


}

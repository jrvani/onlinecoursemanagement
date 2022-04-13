package com.epam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.epam.entity.Assignment;
import com.epam.entity.Course;


public class AssignmentDAO implements AssignmentDAOInterface {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-local-mysql");
	EntityManager em = emf.createEntityManager();
	
	public Course getCourse(int id,String courseName)
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
		return course;
				
	}
	
	public void add(Assignment assignment)
	{
		em.getTransaction().begin();
		em.persist(assignment);
		em.getTransaction().commit();
		
	}
	public void delete(int cid,String assignmentName)
	{
		Assignment assignment=null;
		Query query=em.createQuery("select a from Assignment a where course_cid="+cid);
		List<Assignment> list=query.getResultList();
		for(Assignment c:list)
	    {
	    	if(c.getAssignmentName().equals(assignmentName))
	    	{
	    		assignment=c;
	    		break;
	    	}
	    }
		em.getTransaction().begin();
		em.remove(assignment);
		em.getTransaction().commit();
		
		
	}
	public List<Assignment> view(int cid)
	{
		
		Query query=em.createQuery("select a from Assignment a where course_cid="+cid);
		List<Assignment> list=query.getResultList();
		return list;
	}
	
	
	


}

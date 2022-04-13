package com.epam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.epam.entity.Assignment;
import com.epam.entity.Question;
import com.epam.utility.EntityManagerUtil;
@Repository
public class QuestionDAOImpl implements QuestionDAO {
	
	
	EntityManagerFactory emf=EntityManagerUtil.getFactory();
	 public Assignment getAssignment(String assignment)
	 {
		 EntityManager em = emf.createEntityManager();
		 em.getTransaction().begin();
		 TypedQuery<Assignment> query=em.createQuery("Select a from Assignment a where assignment_name=:assignment",Assignment.class);
		 query.setParameter("assignment", assignment);
		 List<Assignment> list=query.getResultList();
		em.close();
		 return list.get(0);
	 }
	public void add(Question question)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(question);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void delete(Assignment ass,int id)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        Query query=em.createQuery("delete from Question where question_id=:id and assignment_assignment_id=:assid");
        query.setParameter("id", id);
        query.setParameter("assid", ass.getAssignmentId());
		
	
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Question> view(Assignment assignment)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Question> query=em.createQuery("select a from Question a where assignment_assignment_id=:id",Question.class);
		query.setParameter("id",assignment.getAssignmentId());
		List<Question> list=query.getResultList();
	
		em.close();
	
		return list;
	}

	

}

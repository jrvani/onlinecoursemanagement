package com.epam.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	private static EntityManagerFactory emf;
	public EntityManagerFactory getFactory()
	{
		if(emf==null) {
		 emf= Persistence.createEntityManagerFactory("my-local-mysql");
		}
		return emf;

	}
	
	public void closeEmf()
	{
		emf.close();
	}
	
}

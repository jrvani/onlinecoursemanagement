package com.epam.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	
	
	private static EntityManagerFactory emf;
	private EntityManagerUtil() {}
   
    public static EntityManagerFactory getFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("my-local-mysql");
        }
        return emf;
    }

    public static void tearDown() {
        if (emf != null) {
            emf.close();
        }
    }
}

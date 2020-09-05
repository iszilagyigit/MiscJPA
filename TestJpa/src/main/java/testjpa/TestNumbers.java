package testjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestNumbers {
 public static void main(String[] args) {

	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TESTJPA_PU");
	 System.out.println("ENTITY MANAGER FACTORY: " + emf);
	 EntityManager em = emf.createEntityManager();
	 System.out.println("ENTITY MANAGER: " + em);
	
	 // Native query with resultset mapping
	 //List<?> resultList = em.createNativeQuery("select num19 from t1","idlong").getResultList();
	 
	 // Named (native) Query with resultset mapping and type
	 List<Long> resultList = em.createNamedQuery("query19", Long.class).getResultList();
	 System.out.println(resultList.get(0).getClass() + " - " + resultList.get(0));
	 em.close();
	 emf.close();
	 
}
}

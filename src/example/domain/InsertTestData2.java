package example.domain;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.transaction.annotation.Transactional;

// see lahendus ei toimi kuna MVC projektis onconnection teisiti
//  No appropriate connection provider encountered

public class InsertTestData2 {
	
    public static void main(String[] args) {
        insertData();
    }
	//@Transactional
	private static void insertData() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-hsql-unit");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    
	    AdminUnit unit1 = createAdminUnit("esimene2", "esimene", 1L, "testUserNam", "kommentaar");
	    AdminUnit unit2 = createAdminUnit("teine2", "teine", 1L, "testUserNam", "kommentaar");
	    AdminUnit unit3 = createAdminUnit("kolmas2", "kolmas", 1L, "testUserNam", "kommentaar");
	    AdminUnit unit4 = createAdminUnit("neljas2", "neljas", 1L, "testUserNam", "kommentaar");
	    
	    em.persist(unit1); // paneb paasi
        em.persist(unit2);
        em.persist(unit3);
        em.persist(unit4);
        
        em.flush(); // kirjuta kindlasti kõik baasi maha
        em.refresh(unit1); // ja loe kõik uuesti sisse
        em.refresh(unit2); // alles peale seda saab subordinates add teha
        em.refresh(unit3);
        em.refresh(unit4);
	    
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	}
	
    
    private static AdminUnit createAdminUnit(String code, String name, Long typeId, String userName, String comment) {
		//Integer typeId = typeDao.getTypeIdByCode(typeCode); 
		
		AdminUnit unit = new AdminUnit();
	
		unit.setKood(code);
		unit.setNimetus(name);
		Date date = new Date();
		unit.setAlates(date);
		unit.setAvatud(date);
		unit.setAvaja(userName);
		unit.setKuni(date);
		//unit.setTypeId(typeId);
		unit.setType_id(typeId);
		unit.setKommentaar(comment);
		
		return unit;
	}

}

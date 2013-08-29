package example.domain;

import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import example.dao.AdminUnitTypeDao;

@Repository
public class InsertTestData {
	
	@PersistenceContext
    private EntityManager em;
    
    @Resource
	private AdminUnitTypeDao adminTypeDao;
    
	public void insertTestData() {
		//deleteExistingData();

//		EntityManagerFactory emf = GenericService.getEntityManagerFactory();
//    	em = emf.createEntityManager();
		
		//insertTestAdminUnitTypes();
		insertTestAdminUnits();
		
		em.close();
		//emf.close();
	}
	
	@Transactional
	public void insertTestAdminUnits() {
		em.getTransaction().begin();

	    AdminUnit unit1 = createAdminUnit("esimene", "esimene", 1L, "testUserNam");
	    AdminUnit unit2 = createAdminUnit("teine", "teine",  1L, "testUserNam");
	    AdminUnit unit3 = createAdminUnit("kolmas", "kolmas", 1L, "testUserNam");
	    AdminUnit unit4 = createAdminUnit("neljas", "neljas", 1L, "testUserNam");
	    
//	    addBossToUnit(uVA01, uKU01);
//	    addBossToUnit(uVA01, uKU02);
//	    addBossToUnit(uVA02, uKU03);
//	    addBossToUnit(uVA02, uKU04);

	    
	    em.getTransaction().commit();
	}
	
	private AdminUnit createAdminUnit(String code, String name, Long typeId, String userName) {
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
		
		em.persist(unit);
		return unit;
	}
	
//	@Transactional
//    public void insertAdminUnitData() {
//		AdminUnitDao adminUnitDao= new AdminUnitDao();
//		AdminUnit unit1 = adminUnitDao.greateAdminUnit("1", "esimene", "ylem");
//		AdminUnit unit2 = adminUnitDao.greateAdminUnit("2", "teine", "allub esimesele");
//		AdminUnit unit3 = adminUnitDao.greateAdminUnit("3", "kolmas", "allub teisele");
//		AdminUnit unit4 = adminUnitDao.greateAdminUnit("4", "neljas", "allub kolmandale");
//		
//		em.persist(unit1);
//		em.persist(unit2);
//		em.persist(unit3);
//		em.persist(unit4);
//		
//		em.flush();//baasi sync
//		
//		em.refresh(unit1); //uendame olemid
//		em.refresh(unit2);
//		em.refresh(unit3);
//		em.refresh(unit4);
//	}
	

}

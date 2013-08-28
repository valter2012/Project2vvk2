package example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import example.domain.AdminUnitType;

@Repository
public class AdminUnitTypeDao {
	
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public void store(AdminUnitType adminUnitType) {
        em.merge(adminUnitType);
    }
    
    @Transactional(readOnly = true)
    public List<AdminUnitType> findAll() {
        TypedQuery<AdminUnitType> query = em.createQuery("from AdminUnit", AdminUnitType.class);
        return query.getResultList();
    }
    
    @Transactional
    public void delete(Long id) {
    	AdminUnitType adminUnitType = em.find(AdminUnitType.class, id);
        if (adminUnitType != null) em.remove(adminUnitType);
    }
    
    @Transactional(readOnly = true)
    public AdminUnitType load(Long id) {
        return em.find(AdminUnitType.class, id);
    }

}

package example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import example.domain.AdminUnit;

@Repository
public class AdminUnitDao {
	
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public void store(AdminUnit adminUnit) {
        em.merge(adminUnit);
    }
    
    @Transactional(readOnly = true)
    public List<AdminUnit> findAll() {
        TypedQuery<AdminUnit> query = em.createQuery("from AdminUnit", AdminUnit.class);
        return query.getResultList();
    }
    
    @Transactional
    public void delete(Long id) {
    	AdminUnit adminUnit = em.find(AdminUnit.class, id);
        if (adminUnit != null) em.remove(adminUnit);
    }
    
    @Transactional(readOnly = true)
    public AdminUnit load(Long id) {
        return em.find(AdminUnit.class, id);
    }

}

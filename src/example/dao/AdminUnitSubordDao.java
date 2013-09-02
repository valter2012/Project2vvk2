package example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import example.domain.AdminUnit;
import example.domain.AdminUnitSubord;

public class AdminUnitSubordDao {
	
	
    @PersistenceContext
    private EntityManager em;
	
    @Transactional(readOnly = true)
    public List<AdminUnitSubord> findAllSubs(Long id) {
        TypedQuery<AdminUnitSubord> query = em.createQuery("from  AdminUnitSubord where head_id = :id", AdminUnitSubord.class);
        return query.getResultList();
    }
    
    
    @Transactional(readOnly = true)
    public List<AdminUnitSubord> findHead(Long id) {
        TypedQuery<AdminUnitSubord> query = em.createQuery("from  AdminUnitSubord where sub_id = :id", AdminUnitSubord.class);
        return query.getResultList();
    }
   
    @Transactional
    public void store(AdminUnitSubord adminUnitSubord) {
        em.merge(adminUnitSubord);
    }
    
    @Transactional
    public void delete(Long SubId, Long HeadId) {
    	TypedQuery<AdminUnitSubord> query = em.createQuery("from  AdminUnitSubord where sub_id = :id", AdminUnitSubord.class);
    	//AdminUnit adminUnit = query.getResultList()
        //if (adminUnit != null) em.remove(query.getResultList());
    }

}

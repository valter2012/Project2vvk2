package example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import example.domain.Person;

@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void store(Person person) {
        em.merge(person);
    }

    @Transactional(readOnly = true)
    public List<Person> findAll() {
        TypedQuery<Person> query = em.createQuery("from Person", Person.class);
        return query.getResultList();
    }

    @Transactional
    public void delete(Long personId) {
        Person person = em.find(Person.class, personId);
        if (person != null) em.remove(person);
    }

    @Transactional(readOnly = true)
    public Person load(Long personId) {
        return em.find(Person.class, personId);
    }

}

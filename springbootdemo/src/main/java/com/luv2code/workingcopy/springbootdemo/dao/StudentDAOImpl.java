package com.luv2code.workingcopy.springbootdemo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.workingcopy.springbootdemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

// ALL JPA queries utilize entity name/fields, NOT database names

// REPOSITORY - spring component
// TRANSACTIONAL - needed for adding/updating data, NOT for read only queries
@Repository
public class StudentDAOImpl implements StudentDAO {

    // entity manager dependency to inject into methods
    private EntityManager entityManager;

    // constructors
    public StudentDAOImpl() {
    }

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // methods
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // used the java class field lastName, NOT the database last_name
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        // JPQL named parameters are prefixed with :
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName = :theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        
        entityManager.merge(theStudent);
        
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        entityManager.remove(findById(id));
    }

}

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
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

}

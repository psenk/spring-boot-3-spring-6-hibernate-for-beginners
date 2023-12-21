package com.luv2code.workingcopy.springbootdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.workingcopy.springbootdemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

// REPOSITORY - spring component
@Repository
public class StudentDAOImpl implements StudentDAO {

    // entity manager dependency to inject into save method
    private EntityManager entityManager;

    // constructors
    public StudentDAOImpl() {
    }

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

}

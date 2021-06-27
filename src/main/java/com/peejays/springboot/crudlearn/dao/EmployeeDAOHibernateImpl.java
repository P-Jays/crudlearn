package com.peejays.springboot.crudlearn.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.peejays.springboot.crudlearn.entity.Employee;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> theQuery = session.createQuery("from Employee",Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }


    @Override
    public Employee findById(int id) {
        Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class, id);

        return employee;
    }


    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);
        
    }


    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Employee where id=:employeeId ");
        
        query.setParameter("employeeId", id);

        query.executeUpdate();

        
    }
    
}

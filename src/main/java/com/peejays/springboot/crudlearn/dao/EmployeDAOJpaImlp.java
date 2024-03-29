package com.peejays.springboot.crudlearn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.peejays.springboot.crudlearn.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeDAOJpaImlp implements EmployeeDAO {

    private EntityManager entityManager ;


    @Autowired
    public EmployeDAOJpaImlp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");

        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        employee.setId(dbEmployee.getId());
        
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId ");
        
        query.setParameter("employeeId", id);

        query.executeUpdate();
        
    }
    
    
}

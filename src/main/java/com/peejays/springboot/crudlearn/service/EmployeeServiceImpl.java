package com.peejays.springboot.crudlearn.service;

import java.util.List;

import com.peejays.springboot.crudlearn.dao.EmployeeDAO;
import com.peejays.springboot.crudlearn.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeDAOJpaImlp") EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeDAO.findById(id);
        
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
        
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.delete(id);
        
    }
    
}

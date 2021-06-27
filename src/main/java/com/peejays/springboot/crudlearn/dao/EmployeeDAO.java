package com.peejays.springboot.crudlearn.dao;

import java.util.List;

import com.peejays.springboot.crudlearn.entity.Employee;

public interface EmployeeDAO {
    
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void delete(int id);
}

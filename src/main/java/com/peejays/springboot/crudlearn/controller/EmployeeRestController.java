package com.peejays.springboot.crudlearn.controller;

import java.util.List;


import com.peejays.springboot.crudlearn.entity.Employee;
import com.peejays.springboot.crudlearn.service.EmployeeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();        
    }

    @GetMapping("/employees/{id}")
    public Employee findByIdEmployee(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }


    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.delete(id);
    }
    
}

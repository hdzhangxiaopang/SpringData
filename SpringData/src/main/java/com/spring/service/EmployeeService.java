package com.spring.service;

import com.spring.domain.Employee;
import com.spring.repository.EmployeeCrudRepository;
import com.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void updateEmployeeAgeById(Integer id,Integer age){
        employeeRepository.updateEmployeeAgeById(id,age);
    }

    @Transactional
    public void save(List<Employee> employees){
        employeeCrudRepository.save(employees);
    }


}

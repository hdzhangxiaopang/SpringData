package com.spring.repository;

import com.spring.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrudRepository extends CrudRepository<Employee,Integer> {
}

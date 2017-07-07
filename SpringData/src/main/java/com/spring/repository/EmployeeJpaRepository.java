package com.spring.repository;


import com.spring.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {

}

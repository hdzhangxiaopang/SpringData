package com.spring.repository;

import com.spring.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeJpaSpecificationExecutorRepository
        extends JpaRepository<Employee,Integer>,JpaSpecificationExecutor<Employee>{

}

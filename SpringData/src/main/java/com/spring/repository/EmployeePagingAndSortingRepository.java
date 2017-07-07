package com.spring.repository;


import com.spring.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePagingAndSortingRepository  extends PagingAndSortingRepository<Employee,Integer>{

}

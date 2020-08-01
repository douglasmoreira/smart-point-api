package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface EmployeeService {

    /**
     * @param employee
     * @return employee
     */
    Employee persist(Employee employee);

    /**
     * @param cpf
     * @return Employee
     */
    Employee findByCpf(String cpf);

    /**
     * @param email
     * @return Employee
     */
    Employee findByEmail(String email);

    /**
     * @param id
     * @return Optional<Employee>
     */
    Optional<Employee> findById(Long id);
}

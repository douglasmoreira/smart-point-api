package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee persist(Employee employee) {
        log.info("Persist Employee: {}", employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findByCpf(String cpf) {
        log.info("Find Employee by CPF {}", cpf);
        return employeeRepository.findByCpf(cpf);
    }

    @Override
    public Employee findByEmail(String email) {
        log.info("Find Employee by email {}", email);
        return employeeRepository.findByEmail(email);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        log.info("Find Employee by ID {}", id);
        return employeeRepository.findById(id);
    }
}

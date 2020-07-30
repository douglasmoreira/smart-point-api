package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface Employee extends JpaRepository<Employee, Long> {

    Employee findByCpf(String cpf);

    Employee findByEmail(String email);

    Employee findByCpfOrEmail(String cpf, String email);
}

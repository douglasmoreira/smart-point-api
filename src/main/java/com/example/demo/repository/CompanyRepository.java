package com.example.demo.repository;

import com.example.demo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CompanyRepository extends JpaRepository<CompanyRepository, Long> {

    @Transactional(readOnly = true)
    Company findByCnpj(String cnpj);
}

package com.example.demo.service.impl;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company findByCnpj(String cnpj) {

        log.info("find company by cnpj {}", cnpj);
        return companyRepository.findByCnpj(cnpj);
    }

    @Override
    public Company persist(Company company) {
        log.info("Persist Company: {}", company);
        return companyRepository.save(company);
    }
}

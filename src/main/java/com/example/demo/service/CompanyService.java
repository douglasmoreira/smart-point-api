package com.example.demo.service;

import com.example.demo.entity.Company;

public interface CompanyService {

    /**
     * @param cnpj
     * @return Company
     */
    Company findByCnpj(String cnpj);

    /**
     * @param company
     * @return Employee
     */
    Company persist(Company company);
}

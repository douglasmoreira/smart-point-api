//package com.example.demo.repository;
//
//import com.example.demo.entity.Company;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//public interface CompanyRepository extends JpaRepository<Company, Long> {
//
//    @Transactional(readOnly = true)
//    Company findByCnpj(String cnpj);
//}

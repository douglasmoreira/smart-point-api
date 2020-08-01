package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class CompanyServiceTest {

    @MockBean
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    private static final String CNPJ = "51463645000100";

    @BeforeEach
    public void setUp() throws Exception {
        BDDMockito.given(this.companyRepository.findByCnpj(Mockito.anyString())).willReturn(new Company());

        BDDMockito.given(this.companyRepository.save(Mockito.any(Company.class))).willReturn(new Company());
    }

    @Test
    public void testFindCompanyByCnpj() {
        Company company = this.companyService.findByCnpj(CNPJ);

        assertNotNull(company);
    }

    @Test
    public void testPersistCompany() {
        Company company = this.companyService.persist(new Company());

        assertNotNull(company);
    }
}

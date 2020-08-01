package com.example.demo.repository;

import com.example.demo.entity.Company;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    private static final String CNPJ = "51463645000100";

    @BeforeEach
    public void setUp() throws Exception {
        Company company = new Company();
        company.setCompanyName("Example company");
        company.setCnpj(CNPJ);
        this.companyRepository.save(company);
    }



    @AfterEach
    public final void tearDown() {
        this.companyRepository.deleteAll();
    }

    @Test
    public void testGetByCnj() {
        Company company = this.companyRepository.findByCnpj(CNPJ);

        assertEquals(CNPJ, company.getCnpj());
    }
}

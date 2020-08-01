package com.example.demo.repository;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.enums.EnumProfile;
import com.example.demo.utils.PasswordUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private  CompanyRepository companyRepository;

    private static final String EMAIL = "email@email.com";
    private static final String CPF = "24291173474";
    private Company company;

    @BeforeEach
    public void setUp() throws Exception {
        this.employeeRepository.save(getDataEmployee());
        company = this.companyRepository.save(getCompanyData());
    }

    @AfterEach
    public final void tearDown() {
        this.companyRepository.deleteAll();
        this.employeeRepository.deleteAll();
    }

    @Test
    public void testGetEmployeeByEmail() {
        Employee employee = this.employeeRepository.findByEmail(EMAIL);

        assertEquals(EMAIL, employee.getEmail());
    }

    @Test
    public void testGetEmployeeByCpf() {
        Employee employee = this.employeeRepository.findByCpf(CPF);

        assertEquals(CPF, employee.getCpf());
    }

    @Test
    public void testGetEmployeeByEmailOrCpf() {
        Employee employee = this.employeeRepository.findByCpfOrEmail(CPF, EMAIL);

        assertNotNull(employee);
    }

    @Test
    public void testGetEmployeeByEmailOrCpfInvalid() {
        Employee employee = this.employeeRepository.findByCpfOrEmail(CPF, "email@invalid.com");

        assertNotNull(employee);
    }
    @Test
    public void testGetEmployeeByEmailOrCpfInvalid2() {
        Employee employee = this.employeeRepository.findByCpfOrEmail("1234567890", EMAIL);

        assertNotNull(employee);
    }

    private Company getCompanyData() {

        Company company = new Company();
        company.setCompanyName("Company example");
        company.setCnpj("51463645000100");
        return company;
    }

    private Employee getDataEmployee() {

        Employee employee = new Employee();
        employee.setName("fulano");
        employee.setProfile(EnumProfile.ROLE_USER);
        employee.setPassword(PasswordUtils.createBCrYpt("123456"));
        employee.setCpf(CPF);
        employee.setEmail(EMAIL);
        employee.setCompany(company);
        return  employee;
    }
}

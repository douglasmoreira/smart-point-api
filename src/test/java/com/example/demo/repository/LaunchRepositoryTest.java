package com.example.demo.repository;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Launch;
import com.example.demo.enums.EnumProfile;
import com.example.demo.enums.EnumTypes;
import com.example.demo.utils.PasswordUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class LaunchRepositoryTest {

    @Autowired
    private LaunchRepository launchRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    private Long employeeId;

    private Employee employee;

    private Company company;

    @BeforeEach
    public void setUp() throws Exception {
        company = this.companyRepository.save(getCompanyData());

        employee = this.employeeRepository.save(getEmployeeData());

        this.employeeId = employee.getId();

        this.launchRepository.save(getLaunchData());
        this.launchRepository.save(getLaunchData());
    }

    @AfterEach
    public void  tearDown() throws Exception {
        this.companyRepository.deleteAll();
    }

    @Test
    public void testGetLaunchByEmployeeId() {
        List<Launch>  release = this.launchRepository.findByEmployeeId(employeeId);

        assertEquals(2, release.size());
    }

    @Test
    public void testGetLaunchByEmployeeIdPageable() {
        PageRequest page =  PageRequest.of(0,10);

        Page<Launch> release = this.launchRepository.findByEmployeeId(employeeId,page);

        assertEquals(2, release.getTotalElements());
    }

    private Company getCompanyData() {
        Company company = new Company();
        company.setCompanyName("Empresa de exemplo");
        company.setCnpj("51463645000100");
        return company;
    }

    private Employee getEmployeeData() {
        Employee employee = new Employee();
        employee.setName("Fulano de Tal");
        employee.setProfile(EnumProfile.ROLE_USER);
        employee.setPassword(PasswordUtils.createBCrYpt("123456"));
        employee.setCpf("24291173474");
        employee.setEmail("email@email.com");
        employee.setCompany(company);
        return employee;
    }

    private Launch getLaunchData() {
        Launch launch = new Launch();
        launch.setData(new Date());
        launch.setType(EnumTypes.FINISH_LUNCH);
        launch.setEmployee(employee);
        return launch;
    }
}

package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class EmployeeServiceTest {

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() throws Exception {
        BDDMockito.given(this.employeeRepository.save(Mockito.any(Employee.class))).willReturn(new Employee());

        BDDMockito.given(this.employeeRepository.findById(Mockito.anyLong())).willReturn(java.util.Optional.of(new Employee()));

        BDDMockito.given(this.employeeRepository.findByEmail(Mockito.anyString())).willReturn(new Employee());

        BDDMockito.given(this.employeeRepository.findByCpf(Mockito.anyString())).willReturn(new Employee());
    }

    @Test
    public void testPersistEmployee() {
        Employee employee = this.employeeService.persist(new Employee());

        assertNotNull(employee);
    }

    @Test
    public void testFindEmployeeById() {
        Optional<Employee> employee = this.employeeService.findById(Long.valueOf(1));

        assertTrue(employee.isPresent());
    }

    @Test
    public void testFindEmployeeByEmail() {
        Employee employee = this.employeeService.findByEmail("email@email.com");

        assertNotNull(employee);
    }

    @Test
    public void testFindEmployeeByCpf() {
        Employee employee = this.employeeService.findByCpf("24291173474");

        assertNotNull(employee);
    }


}

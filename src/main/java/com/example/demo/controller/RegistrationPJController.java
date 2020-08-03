package com.example.demo.controller;

import com.example.demo.dtos.RegistrationPJDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.enums.EnumProfile;
import com.example.demo.response.Response;
import com.example.demo.service.CompanyService;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.PasswordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/registration-pj")
@CrossOrigin(origins = "*")
public class RegistrationPJController {

    private static final Logger log = LoggerFactory.getLogger(RegistrationPJController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    public RegistrationPJController() {
    }

    /**
     * @param registrationPJDto
     * @param result
     * @return ResponseEntity<Response < RegistrationPJDto>>
     * @throws NoSuchAlgorithmException
     */
    @PostMapping
    public ResponseEntity<Response<RegistrationPJDto>> register(@Valid @RequestBody RegistrationPJDto registrationPJDto, BindingResult result) throws NoSuchAlgorithmException {
        log.info("Registration PJ: {}", registrationPJDto);
        Response<RegistrationPJDto> response = new Response<>();

        Company company = this.convertRegistrationPJDtoToCompany(registrationPJDto);
        Employee employee = this.convertRegistrationPJDtoToEmployee(registrationPJDto);

        if (result.hasErrors()) {
            log.error("Erro validando dados de cadastro PJ: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        this.companyService.persist(company);
        employee.setCompany(company);
        this.employeeService.persist(employee);

        response.setData(this.convertEmployeeToRegistrationPJDto(employee));
        return ResponseEntity.ok(response);
    }

    /**
     * @param registrationPJDto
     * @return Employee
     */
    private Employee convertRegistrationPJDtoToEmployee(RegistrationPJDto registrationPJDto) {
        Employee employee = new Employee();
        employee.setName(registrationPJDto.getName());
        employee.setEmail(registrationPJDto.getEmail());
        employee.setCpf(registrationPJDto.getCpf());
        employee.setProfile(EnumProfile.ROLE_ADMIN);
        employee.setPassword(PasswordUtils.createBCrYpt(registrationPJDto.getPassword()));
        return employee;
    }

    /**
     * @param registrationPJDto
     * @return Company
     */
    private Company convertRegistrationPJDtoToCompany(RegistrationPJDto registrationPJDto) {
        Company company = new Company();
        company.setCnpj(registrationPJDto.getCnpj());
        company.setCompanyName(registrationPJDto.getCompanyName());
        return company;
    }

    /**
     * @param employee
     * @return RegistrationPJDto
     */
    private RegistrationPJDto convertEmployeeToRegistrationPJDto(Employee employee) {
        RegistrationPJDto registrationPJDto = new RegistrationPJDto();
        registrationPJDto.setId(employee.getId());
        registrationPJDto.setName(employee.getName());
        registrationPJDto.setEmail(employee.getEmail());
        registrationPJDto.setCpf(employee.getCpf());
        registrationPJDto.setCompanyName(employee.getCompany().getCompanyName());
        registrationPJDto.setCnpj(employee.getCompany().getCnpj());

        return registrationPJDto;
    }
}

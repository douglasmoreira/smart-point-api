package com.example.demo.dtos;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class RegistrationPJDto {

    private Long id;

    @NotEmpty(message = "can't empty name.")
    @Length(min = 3, max = 200, message = "Name must be between 3 and 200.")
    private String name;

    @NotEmpty(message = "can't empty email.")
    @Length(min = 5, max = 200, message = "Name must be between 5 and 200.")
    @Email(message = "Invalid email.")
    private String email;

    @NotEmpty(message = "can't empty password")
    private String password;

    @NotEmpty(message = "can't empty CPF")
    @CPF(message = "invalid CPF")
    private String cpf;

    @NotEmpty(message = "can't empty Company Name")
    @Length(min = 5, max = 200, message = "Company Name must be between 3 and 200.")
    private String companyName;

    @NotEmpty(message = "can't empty CNPJ")
    @CNPJ(message = "CNPJ invalid")
    private String cnpj;

    public RegistrationPJDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "registrationPJ{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cpf='" + cpf + '\'' +
                ", CompanyName='" + companyName + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

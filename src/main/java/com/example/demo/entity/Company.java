package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "company")
public class Company implements Serializable {

    private static final long serialVersionUID = -3207380027589411496L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;

    @Column(name = "date_creation", nullable = false)
    private Date dateCreation;

    @Column(name = "date_update", nullable = false)
    private Date dateUpdate;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Company() {
        super();
    }

    public List<Employee> getEmployee() {
        return employees;
    }

    public void setEmployee(List<Employee> employee) {
        this.employees = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @PreUpdate
    public void preUpdate() {
        dateUpdate = new Date();
    }

    @PrePersist
    public void prePersit() {
        final Date atual = new Date();
        dateCreation = atual;
        dateUpdate = atual;
    }


}

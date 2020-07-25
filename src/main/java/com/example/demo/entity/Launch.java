package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.enums.EnumTypes;

public class Launch implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Column
	private String description;
	
	@Column
	private String location;
	
	@Column(name = "date_Creation")
	private Date dateCreation;
	
	@Column(name = "date_Update")
	private Date dateUpdate;
	
	@Enumerated(EnumType.STRING)
	@Column
	private EnumTypes type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Employee employee;
	
	public Launch() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public EnumTypes getType() {
		return type;
	}
	public void setType(EnumTypes type) {
		this.type = type;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@PreUpdate
	public void preUpdate() {
		dateCreation = new Date();
	}
	
	@PrePersist
	public void prePersit() {
		final Date atual = new Date();
		dateCreation = atual;
		dateUpdate = atual;
	}

	@Override
	public String toString() {
		return "Launch [id=" + id + ", data=" + data + ", description=" + description + ", location=" + location
				+ ", dateCreation=" + dateCreation + ", dateUpdate=" + dateUpdate + ", type=" + type + ", employee="
				+ employee + "]";
	}
	

}

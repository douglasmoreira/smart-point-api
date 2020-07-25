package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.demo.enums.EnumProfile;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{

	static final long serialVersionUID = 3295386912126783994L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "hour_value", nullable = true)
	private BigInteger hourValue;
	
	@Column(name = "amount_of_hour_worked", nullable = true)
	private Float amountOfHourWorked;
	
	@Column(name = "amount_of_lunch_time", nullable = false)
	private Float amoutOfLunchTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "profile", nullable = false)
	private EnumProfile profile;
	
	@Column(name = "date_criation", nullable = false)
	private Date dateCreation;
	
	@Column(name = "date_update", nullable = false)
	private Date dateUpdate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Employee employee;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Launch> launch;

	public Employee() {
		super();
	}

	@Transient
	public Optional<BigInteger> getAmountHourOpt() {
		return Optional.ofNullable(hourValue);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public BigInteger getHourValue() {
		return hourValue;
	}

	public void setHourValue(BigInteger hourValue) {
		this.hourValue = hourValue;
	}

	public Float getAmountOfHourWorked() {
		return amountOfHourWorked;
	}

	public void setAmountOfHourWorked(Float amountOfHourWorked) {
		this.amountOfHourWorked = amountOfHourWorked;
	}

	public Float getAmoutOfLunchTime() {
		return amoutOfLunchTime;
	}

	public void setAmoutOfLunchTime(Float amoutOfLunchTime) {
		this.amoutOfLunchTime = amoutOfLunchTime;
	}

	public EnumProfile getProfile() {
		return profile;
	}

	public void setProfile(EnumProfile profile) {
		this.profile = profile;
	}

	public Date getDateCriation() {
		return dateCreation;
	}

	public void setDateCriation(Date dateCriation) {
		this.dateCreation = dateCriation;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Launch> getLaunch() {
		return launch;
	}

	public void setLaunch(List<Launch> launch) {
		this.launch = launch;
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
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf=" + cpf
				+ ", hourValue=" + hourValue + ", amountOfHourWorked=" + amountOfHourWorked + ", amoutOfLunchTime="
				+ amoutOfLunchTime + ", profile=" + profile + ", dateCriation=" + dateCreation + ", dateUpdate="
				+ dateUpdate + ", employee=" + employee + ", launch=" + launch + "]";
	}
	
	
	
	
}

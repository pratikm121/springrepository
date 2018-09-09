package com.ibm.spring.boot.model;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class Contacts {
	
	private BigDecimal id;
	private String name;	
	private String email;
	private String homeAddress;
	private String officeAddress;
	private Timestamp createTimestamp;
	private BigDecimal mobile;
	private BigDecimal mobile_2;
	private BigDecimal home;
	private BigDecimal office;
	
	public Contacts(BigDecimal id, String name, String email, String homeAddress, String officeAddress,
			Timestamp createTimestamp, BigDecimal mobile, BigDecimal mobile_2, BigDecimal home, BigDecimal office) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
		this.createTimestamp = createTimestamp;
		this.mobile = mobile;
		this.mobile_2 = mobile_2;
		this.home = home;
		this.office = office;
	}
	
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getMobile() {
		return mobile;
	}
	public void setMobile(BigDecimal mobile) {
		this.mobile = mobile;
	}
	public BigDecimal getMobile_2() {
		return mobile_2;
	}
	public void setMobile_2(BigDecimal mobile_2) {
		this.mobile_2 = mobile_2;
	}
	public BigDecimal getHome() {
		return home;
	}
	public void setHome(BigDecimal home) {
		this.home = home;
	}
	public BigDecimal getOffice() {
		return office;
	}
	public void setOffice(BigDecimal office) {
		this.office = office;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Timestamp getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	
	@Override
	public String toString() {
		return "Contacts [id=" + id + ", name=" + name + ", email=" + email + ", homeAddress=" + homeAddress
				+ ", officeAddress=" + officeAddress + ", createTimestamp=" + createTimestamp + ", mobile=" + mobile
				+ ", mobile_2=" + mobile_2 + ", home=" + home + ", office=" + office + "]";
	}
	

}

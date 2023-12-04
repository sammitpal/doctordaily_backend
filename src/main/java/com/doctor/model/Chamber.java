package com.doctor.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="chambers")
public class Chamber {
	
	@Id
	private String chamberid;
	private String chamberName;
	private String country;
	private String address;
	private String locality;
	private String province;
	private String state;
	private String zipcode;
    @OneToMany(mappedBy = "chamber", cascade = CascadeType.ALL)
	private List<ChamberAppointment> chamberAppointments;
    @ManyToOne
    @JoinColumn(name = "doctors_doctorId")
	private Doctor doctor;
	public String getChamberid() {
		return chamberid;
	}
	public void setChamberid(String chamberid) {
		this.chamberid = chamberid;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@JsonBackReference
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getChamberName() {
		return chamberName;
	}
	public void setChamberName(String chamberName) {
		this.chamberName = chamberName;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@JsonManagedReference
	public List<ChamberAppointment> getChamberAppointments() {
		return chamberAppointments;
	}
	public void setChamberAppointments(List<ChamberAppointment> chamberAppointments) {
		this.chamberAppointments = chamberAppointments;
	}
	
	
}

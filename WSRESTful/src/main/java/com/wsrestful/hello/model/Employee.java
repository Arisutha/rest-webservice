package com.wsrestful.hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="t_employee")
@JsonIgnoreProperties(ignoreUnknown=true) 
// untuk mengabaikan apabila ada data yang di insert di ada di model
// dan data gelap tersebut biasanya untuk diinsert ke table lain 
// dalam kasus insert dalam dua table sekaligus
public class Employee {

	private Integer idEmployee;
	private String nik;
	private String status;
	
	private Integer personalDetailId;
	
	private PersonalDetail personalDetail;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="id_employee", nullable=false)
	public Integer getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}

	@Column(name="nik", length=50, unique=true, nullable=false)
	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	@Column(name="status", columnDefinition="enum('Active','Resign')") //hati2 menggunakan enum karena tidak semua database ada, oracle tidak ada enumerasi jadi gunakan string saja
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="personal_detail_id")
	public Integer getPersonalDetailId() {
		return personalDetailId;
	}

	public void setPersonalDetailId(Integer personalDetailId) {
		this.personalDetailId = personalDetailId;
	}

	@OneToOne
	@JoinColumn(name="personal_detail_id", insertable=false, updatable=false)
	public PersonalDetail getPersonalDetail() {
		return personalDetail;
	}

	public void setPersonalDetail(PersonalDetail personalDetail) {
		this.personalDetail = personalDetail;
	}
	
}

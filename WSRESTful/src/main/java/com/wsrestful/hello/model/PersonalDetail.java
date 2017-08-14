package com.wsrestful.hello.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "t_personal_detail")
@JsonIgnoreProperties(ignoreUnknown = true)
// untuk mengabaikan apabila ada data yang di insert di ada di model,
// dan data gelap tersebut biasanya untuk diinsert ke table lain
// dalam kasus insert dalam dua table sekaligus
public class PersonalDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "personal_detail_id", nullable = false)
	private Integer idPersonalDetail;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "place_of_birth", length = 50)
	private String placeOfBirth;

	@Column(name = "phone", length = 15)
	private String phone;

	@Lob
	@Column(name = "address")
	private String address;

	@Column(name = "gender", columnDefinition = "enum('Pria','Wanita')")
	private String gender;

	@Column(name = "religion", length = 10)
	private String religion;

	@Column(name = "email", length = 50)
	private String email;
}

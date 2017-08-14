package com.wsrestful.hello.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsrestful.hello.dao.PersonalDetailDao;
import com.wsrestful.hello.model.PersonalDetail;

@Service
@Transactional
public class PersonalDetailServiceImpl implements PersonalDetailService {

	@Autowired
	PersonalDetailDao personalDetailDao;
	
	@Override
	public void save(PersonalDetail personalDetail) throws Exception {
		this.personalDetailDao.save(personalDetail);
	}

	@Override
	public void update(PersonalDetail personalDetail) throws Exception {
		PersonalDetail getPersonalDetail = this.personalDetailDao.get(personalDetail.getIdPersonalDetail());
		getPersonalDetail.setAddress(personalDetail.getAddress());
		getPersonalDetail.setDateOfBirth(personalDetail.getDateOfBirth());
		getPersonalDetail.setName(personalDetail.getName());
		getPersonalDetail.setPhone(personalDetail.getPhone());
		getPersonalDetail.setPlaceOfBirth(personalDetail.getPlaceOfBirth());
		getPersonalDetail.setEmail(personalDetail.getEmail());
		getPersonalDetail.setGender(personalDetail.getGender());
		getPersonalDetail.setReligion(personalDetail.getReligion());
		this.personalDetailDao.update(getPersonalDetail);
	}
	
	@Override
	public void delete(PersonalDetail personalDetail) throws Exception {		
		PersonalDetail getPersonalDetail = this.personalDetailDao.get(personalDetail.getIdPersonalDetail());
		this.personalDetailDao.delete(getPersonalDetail);	
	}

	@Override
	public PersonalDetail get(Integer idPersonalDetail) throws Exception {
		return this.personalDetailDao.get(idPersonalDetail);
	}

	@Override
	public Collection<PersonalDetail> listAllPD() throws Exception {
		return this.personalDetailDao.listAllPD();
	}

}

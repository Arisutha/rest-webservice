package com.wsrestful.hello.service;

import java.util.Collection;

import com.wsrestful.hello.model.PersonalDetail;

public interface PersonalDetailService {
	public void save(PersonalDetail personalDetail) throws Exception;
	public void update(PersonalDetail personalDetail) throws Exception;
	public void delete(PersonalDetail personalDetail) throws Exception;
	public PersonalDetail get(Integer idPersonalDetail) throws Exception;
	public Collection<PersonalDetail> listAllPD() throws Exception;
}

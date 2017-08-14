package com.wsrestful.hello.dao;

import java.util.Collection;

import com.wsrestful.hello.model.PersonalDetail;

public interface PersonalDetailDao extends BaseRepository<PersonalDetail>{
	public PersonalDetail get(Integer idPersonalDetail) throws Exception;
	public Collection<PersonalDetail> listAllPD() throws Exception;
}

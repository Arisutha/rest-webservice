package com.wsrestful.hello.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.wsrestful.hello.model.PersonalDetail;

@Repository
public class PersonalDetailDaoImpl extends BaseRepositoryImpl<PersonalDetail> implements PersonalDetailDao{
	
	@Override
	public PersonalDetail get(Integer idPersonalDetail) throws Exception {
	Query query = this.getCurrentSession().createQuery("FROM PersonalDetail WHERE id = :idPersonalDetail").setParameter("idPersonalDetail", idPersonalDetail);
	query.setParameter("idPersonalDetail", idPersonalDetail);
		if(query.list().isEmpty()){
			return null;
		} else {
			return (PersonalDetail) query.list().get(0);
		}
	// fungsi if nya : apabila tidak diberikan kondisi maka akan terjadi error apabila id yang akan di get tidak ada, di database tidak ada	
	}
	
	//	 atau bisa menggunakan cara ini, tapi masih mempunyai kelemahan
	/*@Override
	public PersonalDetail get(Integer idPersonalDetail) throws Exception {
		return (PersonalDetail) this.getCurrentSession().get(PersonalDetail.class, idPersonalDetail);
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public Collection<PersonalDetail> listAllPD() throws Exception {
		return this.getCurrentSession().createQuery("FROM PersonalDetail").list();
	}
}

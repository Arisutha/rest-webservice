package com.wsrestful.hello.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository ("baseRepository")
public class BaseRepositoryImpl<T> implements BaseRepository<T> {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T data) throws Exception {
		this.getCurrentSession().save(data);
	}

	@Override
	public void update(T data) throws Exception {
		this.getCurrentSession().update(data);
	}

	@Override
	public void delete(T data) throws Exception {
		this.getCurrentSession().delete(data);
	}
	
}

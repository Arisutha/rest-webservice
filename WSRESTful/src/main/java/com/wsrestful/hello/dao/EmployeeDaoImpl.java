package com.wsrestful.hello.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.wsrestful.hello.model.Employee;

@Repository
public class EmployeeDaoImpl extends BaseRepositoryImpl<Employee> implements EmployeeDao {
	
	@Override
	public Employee get(Integer idEmployee) throws Exception {
		Query query = this.getCurrentSession().createQuery("FROM Employee WHERE id_employee = :idEmployee");
		query.setParameter("idEmployee", idEmployee);
		if (query.list().isEmpty()){
			return null;			
		} else {
			return (Employee) query.list().get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Employee> listAllEmployee() throws Exception {
		return this.getCurrentSession().createQuery("FROM Employee").list();
	}

}

package com.wsrestful.hello.dao;

import java.util.Collection;

import com.wsrestful.hello.model.Employee;

public interface EmployeeDao extends BaseRepository<Employee>{
	public Employee get(Integer idEmployee) throws Exception;
	public Collection<Employee> listAllEmployee() throws Exception;
	
}

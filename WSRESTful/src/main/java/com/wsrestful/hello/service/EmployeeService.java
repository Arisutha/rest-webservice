package com.wsrestful.hello.service;

import java.util.Collection;

import com.wsrestful.hello.model.Employee;
import com.wsrestful.hello.model.PersonalDetail;

public interface EmployeeService {
	public void save(Employee employee) throws Exception;
	public void update(Employee employee) throws Exception;
	public void delete(Employee employee) throws Exception;
	public Employee get(Integer idEmployee) throws Exception;
	public Collection<Employee> listAllEmployee() throws Exception;
	public Employee saveEPD(PersonalDetail personalDetail, Employee employee) throws Exception;
	public Employee updateEPD(PersonalDetail personalDetail, Employee employee) throws Exception;
}

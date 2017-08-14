package com.wsrestful.hello.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsrestful.hello.dao.EmployeeDao;
import com.wsrestful.hello.dao.PersonalDetailDao;
import com.wsrestful.hello.model.Employee;
import com.wsrestful.hello.model.PersonalDetail;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired EmployeeDao employeeDao;
	@Autowired PersonalDetailDao personalDetailDao;

	@Override
	public void save(Employee employee) throws Exception {
		this.employeeDao.save(employee);
	}

	@Override
	public void update(Employee employee) throws Exception {
		Employee getEmployee = this.employeeDao.get(employee.getIdEmployee());
		getEmployee.setNik(employee.getNik());
		getEmployee.setStatus(employee.getStatus());
		getEmployee.setPersonalDetailId(employee.getPersonalDetailId());
		this.employeeDao.update(getEmployee);
	}

	@Override
	public void delete(Employee employee) throws Exception {
		Employee getEmployee = this.employeeDao.get(employee.getIdEmployee());
		PersonalDetail personalDetail = this.personalDetailDao.get(getEmployee.getPersonalDetailId()); 
		this.employeeDao.delete(getEmployee);
		this.personalDetailDao.delete(personalDetail);
	}

	@Override
	public Employee get(Integer idEmployee) throws Exception {
		return this.employeeDao.get(idEmployee);
	}

	@Override
	public Collection<Employee> listAllEmployee() throws Exception {
		return this.employeeDao.listAllEmployee();
	}

	@Override
	public Employee saveEPD(PersonalDetail personalDetail, Employee employee)
			throws Exception {
		this.personalDetailDao.save(personalDetail);
		employee.setPersonalDetailId(personalDetail.getIdPersonalDetail());
		employee.setPersonalDetail(personalDetail);
		this.employeeDao.save(employee);
		return employee;
	}

	@Override
	public Employee updateEPD(PersonalDetail personalDetail, Employee employee)
			throws Exception {
		/*PersonalDetail getPersonalDetail = this.personalDetailDao.get(personalDetail.getIdPersonalDetail());
		getPersonalDetail.setAddress(personalDetail.getAddress());
		getPersonalDetail.setDateOfBirth(personalDetail.getDateOfBirth());
		getPersonalDetail.setName(personalDetail.getName());
		getPersonalDetail.setPhone(personalDetail.getPhone());
		getPersonalDetail.setPlaceOfBirth(personalDetail.getPlaceOfBirth());
		getPersonalDetail.setEmail(personalDetail.getEmail());
		getPersonalDetail.setGender(personalDetail.getGender());
		getPersonalDetail.setReligion(personalDetail.getReligion());
		this.personalDetailDao.update(getPersonalDetail);*/
		Employee getEmployee = this.get(employee.getIdEmployee());
		getEmployee.setNik(employee.getNik());
		getEmployee.setStatus(employee.getStatus());
		this.employeeDao.update(getEmployee);
		return getEmployee;
	}

}

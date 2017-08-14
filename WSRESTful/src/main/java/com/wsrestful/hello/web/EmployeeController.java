package com.wsrestful.hello.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsrestful.hello.model.Employee;
import com.wsrestful.hello.model.PersonalDetail;
import com.wsrestful.hello.service.EmployeeService;

@Controller
public class EmployeeController extends BaseController{

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/employee.json", method=RequestMethod.GET)
	public void employeeListAll(HttpServletResponse resp){
		Collection<Employee> employeeData = null;
		
		try {
			employeeData = this.employeeService.listAllEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map  = new HashMap<String, Object>();
		map.put("dataEmployee", employeeData);
		
		this.encodeToJson(resp, map);
	}
	
	@RequestMapping(value="/employee-get-one.json", method=RequestMethod.POST, headers="Accept=application/json")
	public void employeeGetOne (HttpServletResponse resp, @RequestBody String param){
		ObjectMapper objectMapper =  new ObjectMapper();
		
		Employee employeeData = null;
		
		try {
			employeeData = objectMapper.readValue(param, Employee.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Employee getEmployee = null;
		
		try {
			getEmployee = this.employeeService.get(employeeData.getIdEmployee());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("EmployeeGetOne", getEmployee);
		
		this.encodeToJson(resp, map);
	}
	
	// use model attribut 
	@RequestMapping(value="/get-employee-personaldetail-model-attribute", method=RequestMethod.POST)
	public void detailEmployee (HttpServletRequest req ,HttpServletResponse resp, @ModelAttribute Employee employee){
		
		Employee employeeData = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			employeeData = this.employeeService.get(employee.getIdEmployee());
			map.put("getEmployee", employeeData);
			map.put("isSuccess", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isSuccess", false);
			map.put("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		this.encodeToJson(resp, map);
	}
	
	@RequestMapping(value="/employee-save.do", method=RequestMethod.POST, headers="Accept=application/json")
	public void employeeInsert (HttpServletResponse resp, @RequestBody String param){
		ObjectMapper objectMapper = new ObjectMapper();
		Employee employeeData = null;
		
		try {
			employeeData = objectMapper.readValue(param, Employee.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			this.employeeService.save(employeeData);
			map.put("isSuccess", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isSuccess", false);
			map.put("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		this.encodeToJson(resp, map);
	}
	
	@RequestMapping(value="/employee-update.do", method=RequestMethod.POST, headers="Accept=application/json")
	public void employeeUpdate(HttpServletResponse resp, @RequestBody String param){
		ObjectMapper objectMapper = new ObjectMapper();
		Employee employeeData = null;
		
		try {
			employeeData = objectMapper.readValue(param, Employee.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			this.employeeService.update(employeeData);
			map.put("isSuccess", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isSuccess", false);
			map.put("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		this.encodeToJson(resp, map);
	}
	
	// use model attribut
	@RequestMapping(value="/update-employee-personaldetail-model-attribute", method=RequestMethod.POST)
	public void updateEmployee (HttpServletRequest req, HttpServletResponse resp, @ModelAttribute PersonalDetail personalDetail, @ModelAttribute Employee employee){
		
		Employee employeeData = null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			employeeData = this.employeeService.updateEPD(personalDetail, employee);
			map.put("updateList", employeeData);
			map.put("isSuccess", true);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isSuccess", false);
			map.put("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		this.encodeToJson(resp, map);
	}
	
	@RequestMapping(value="/employee-delete.do", method=RequestMethod.POST, headers="Accept=application/json")
	public void employeeDelete (HttpServletResponse resp, @RequestBody String param){
		ObjectMapper objectMapper = new ObjectMapper();
		Employee employeeData = null;
		
		try {
			employeeData = objectMapper.readValue(param, Employee.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			this.employeeService.delete(employeeData);
			map.put("deleteId", employeeData.getIdEmployee());
			map.put("isSuccess", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isSuccess", false);
			map.put("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		this.encodeToJson(resp, map);
	}
	
	@RequestMapping(value="/personaldetail-employee-save.do", method=RequestMethod.POST, headers="Accept=application/json")
	public void employeePersonalDetailInsert(HttpServletResponse resp, @RequestBody String param){
		ObjectMapper objectMapper = new ObjectMapper();
		Employee employeeData = null;
		PersonalDetail personalDetailData = null;
		
		try {
			employeeData = objectMapper.readValue(param, Employee.class);
			personalDetailData = objectMapper.readValue(param, PersonalDetail.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			this.employeeService.saveEPD(personalDetailData, employeeData);
			map.put("isSuccess", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isSuccess", false);
			map.put("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		this.encodeToJson(resp, map);
	}
	
	// use model attribut
	@RequestMapping(value="/personaldetail-employee-save-model-attribute", method=RequestMethod.POST)
	public void saveEmployee (HttpServletRequest req, HttpServletResponse resp, @ModelAttribute PersonalDetail personalDetail, @ModelAttribute Employee employee){
		Employee employeeData = null;
		String dateOfBirthString = req.getParameter("dateOfBirthString");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			personalDetail.setDateOfBirth(sdf.parse(dateOfBirthString));
			employeeData = this.employeeService.saveEPD(personalDetail, employee);
			map.put("dataEmployee", employeeData);
			map.put("isSuccess", true);
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isSuccess", false);
			map.put("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		this.encodeToJson(resp, map);
	}
}

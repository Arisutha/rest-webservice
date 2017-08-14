package com.wsrestful.hello.web;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsrestful.hello.model.PersonalDetail;
import com.wsrestful.hello.service.PersonalDetailService;

@Controller
public class PersonalDetailController extends BaseController{
	
	@Autowired
	private PersonalDetailService personalDetailService;
	
	@RequestMapping(value="/personaldetail.json", method=RequestMethod.GET)
	public void personalDetailData(HttpServletResponse resp){
		Collection<PersonalDetail> personalDetailData = null;

		try {
			personalDetailData = this.personalDetailService.listAllPD();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PersonalDetailData", personalDetailData);
		
		this.encodeToJson(resp, map);
	}

	@RequestMapping(value="/personaldetail-get-one.json", method = RequestMethod.POST, headers="Accept=application/json")
	public void personalDetailGetOne (HttpServletResponse resp, @RequestBody String param){
		ObjectMapper objectMapper = new ObjectMapper();
		
		PersonalDetail personalDetailData = null;

			try {
				personalDetailData = objectMapper.readValue(param, PersonalDetail.class);
			} catch (JsonParseException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		PersonalDetail getPersonalDetail= null;
		try {
			getPersonalDetail = this.personalDetailService.get(personalDetailData.getIdPersonalDetail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PersonaDetailGetOne", getPersonalDetail);

		this.encodeToJson(resp, map);
	}
	
	
	@RequestMapping(value="/personaldetail-save.do", method = RequestMethod.POST, headers="Accept=application/json")
	public void personalDetailInsert (HttpServletResponse resp, @RequestBody String param){
		ObjectMapper objectMapper = new ObjectMapper();
		PersonalDetail personalDetailData = null;
		
			try {
				personalDetailData = objectMapper.readValue(param, PersonalDetail.class);
			} catch (JsonParseException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			this.personalDetailService.save(personalDetailData);
			map.put("isSuccess", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isSuccess", false);
			map.put("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		this.encodeToJson(resp, map);
	}
	
	@RequestMapping(value="/personaldetail-update.do", method=RequestMethod.POST, headers="Accept=application/json")
	public void personalDetailUpdate (HttpServletResponse resp, @RequestBody String param){
		ObjectMapper objectMapper = new ObjectMapper();
		PersonalDetail personalDetailData = null;
		
		try {
			personalDetailData = objectMapper.readValue(param, PersonalDetail.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Object> map =  new HashMap<String, Object>();
		
		try {
			this.personalDetailService.update(personalDetailData);
			map.put("isSuccess", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isSuccess", false);
			map.put("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		
		this.encodeToJson(resp, map);
	}
	
	@RequestMapping(value="/personaldetail-delete.do", method=RequestMethod.POST, headers = "Accept=application/json")
	public void personalDetailDelete (HttpServletResponse resp, @RequestBody String param){
		ObjectMapper objectMapper = new ObjectMapper();
		PersonalDetail personalDetailData = null;
		
		try {
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
			this.personalDetailService.delete(personalDetailData);
			map.put("isSuccess", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isSuccess", false);
			map.put("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		this.encodeToJson(resp, map);
	}
}

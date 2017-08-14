package com.wsrestful.hello.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {

	@RequestMapping(value="/sample.json", method=RequestMethod.GET)
	public void sampleJSON(HttpServletRequest req, HttpServletResponse resp){
		
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper objectMapper = new ObjectMapper();
		PrintWriter out;
		
		resp.setContentType("application/json");
		
		map.put("Nama", "Andi");
		map.put("NIM", "G1A006010");
		map.put("JenisKelamin", "Laki-Laki");
		map.put("Alamat", "Jakarta");
		
		try {
			out = resp.getWriter();
			objectMapper.writeValue(out, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.wsrestful.hello.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

public class BaseController {
	protected void encodeToJson(HttpServletResponse resp, Map<String, Object> map){
		ObjectMapper objectMapper = new ObjectMapper();
		resp.setContentType("application/json");
		PrintWriter out;
		
		try {
			out = resp.getWriter();
			objectMapper.writeValue(out, map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

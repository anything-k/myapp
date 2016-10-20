package com.any.common.base;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {

	/**
	 * 将请求参数封装进map
	 * @param request
	 * @return
	 */
	protected Map<String, Object> createParamsMap(HttpServletRequest request){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Enumeration<String> paramKeys = request.getParameterNames();
		
		while(paramKeys.hasMoreElements()){
			String key = paramKeys.nextElement();
			paramMap.put(key, request.getParameter(key));
		}
		
		return paramMap;
	}
	
}

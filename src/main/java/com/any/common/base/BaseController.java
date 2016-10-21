package com.any.common.base;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(BaseController.class);

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
	
	/**
	 * 将提交的String参数转换为Date类型
	 * 参考资料：需要进一步研究
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
	}
}

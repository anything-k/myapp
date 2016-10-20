package com.any.test.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.any.common.base.BaseController;
import com.any.test.pojo.UserPojo;

@Controller
@RequestMapping(value="/test")
public class TestController extends BaseController{

	@RequestMapping(value="/page")
	public String test(){
		return "testpage";
	}
	
	@RequestMapping(value="/userinfo")
	public String test(UserPojo u){
		if(u != null){
			System.out.println(u.getId() + " " + u.getName() + " " + u.getBirth());
		}
		
		return "testout";
	}
	
	@RequestMapping(value="/date")
	public String test(Date u){
		if(u != null){
			System.out.println(u);
		}
		
		return "testout";
	}
	
}

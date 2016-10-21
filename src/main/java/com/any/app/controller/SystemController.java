package com.any.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.any.app.pojo.User;
import com.any.common.base.BaseController;

@Controller
@RequestMapping(value="/sys")
public class SystemController extends BaseController {

	@RequestMapping(value="/login")
	public String login(HttpSession session,User user){
		if(user != null){
			
		}
		return "index";
	}
}

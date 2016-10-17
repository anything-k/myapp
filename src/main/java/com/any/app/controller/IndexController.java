package com.any.app.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value="/index")
	public String index(){
		
		return "index";
	}
	
	@RequestMapping(value="/upload",method = RequestMethod.POST)
	public ModelAndView upload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		MultipartHttpServletRequest fileReq = (MultipartHttpServletRequest)request;
		MultipartFile file = fileReq.getFile("file");
		String filename = file.getOriginalFilename();
		
		String uploadpath = request.getServletContext().getRealPath("/") + "/upload"
				+ "/" + filename;
		
		FileOutputStream filewriter = new FileOutputStream(uploadpath);
		filewriter.write(file.getBytes());
		filewriter.flush();
		filewriter.close();
		return new ModelAndView("result").addObject("filepath",uploadpath);
	}
}

package com.pdf.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pdf.tool.model.LoginModel;
import com.pdf.tool.service.LoginService;

@RestController
public class MainController {
	
	@Autowired
	private LoginService service;
	
	@GetMapping(value = "/")
	public ModelAndView loginpage(ModelMap model) {
		
		return new ModelAndView("login");			

	}
	
	@GetMapping(value = "main")
	public ModelAndView homepage(ModelMap model) {
		
		return new ModelAndView("home");			

	}	
	

	@GetMapping(value = "signupform")
	public ModelAndView signuppage(ModelMap model) {
		// return new ModelAndView("home","","");
		
		return new ModelAndView("signup");		
		// return new ModelAndView(new RedirectView("home.jsp"));

	}
	
	@PostMapping(value = "homepage")
	public ModelAndView validateInputs(LoginModel model) {
		System.out.println("Main controller..");
		String userid = model.getUserid();
		String password = model.getPassword();
		
		ModelAndView modelandview = new ModelAndView();
		
		boolean valid =  service.validateInputs(userid, password);
		
		if(valid) {
			modelandview=new ModelAndView("home");		
		}else {
			modelandview=new ModelAndView("login");			
			modelandview.addObject("errormessage", "INVALID CREDENTIALS or UserID not Found");
			
		}
		return modelandview;
	}
	
	@PostMapping(value = "home")
	public ModelAndView addUser(LoginModel model) {
		System.out.println("add user controller..");
		String userid = model.getUserid();
		String password = model.getPassword();
		
		ModelAndView modelandview = new ModelAndView();
		
		boolean valid =  service.addUser(userid, password);
		
		if(valid) {
			modelandview=new ModelAndView("home");		
		}else {
			modelandview=new ModelAndView("signup");			
			modelandview.addObject("errormessage", "INVALID CREDENTIALS or UserID Already Exists");
		}
		return modelandview;
	}

}

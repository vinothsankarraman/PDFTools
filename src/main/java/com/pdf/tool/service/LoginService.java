package com.pdf.tool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdf.tool.controller.FeignInterface;

@Service
public class LoginService {
	
	@Autowired
	FeignInterface feign;
	
	public boolean validateInputs(String userid, String password)
	{
		System.out.println("Validate Inputs.. gonna hit feign..");
		boolean valid = feign.validateInputs(userid, password);
		System.out.println(valid);
		return valid;
	}
	
	public boolean addUser(String userid, String password) {
		boolean valid =  feign.addUser(userid, password);
		System.out.println(valid);
		return valid;
	}

}

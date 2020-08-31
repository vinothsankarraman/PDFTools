package com.pdf.tool.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("LoginMS")
public interface FeignInterface {
	
	@GetMapping(value="/login/{userid}/{password}")
	boolean validateInputs(@PathVariable("userid") String userid, @PathVariable("password") String password);
	
	@PostMapping(value="/login/{userid}/{password}")
	boolean addUser(@PathVariable("userid") String userid, @PathVariable("password") String password);

}

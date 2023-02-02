package com.vinhlam.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinhlam.tool.service.AutoPostStatusFacebook;

@RestController
@RequestMapping("/tool/facebook/")
public class ToolFacebookController {
	
	@Autowired
	private AutoPostStatusFacebook service;
	
//	API test connect: http://localhost:8080/tool/facebook/test
	@GetMapping("test")
	public String test() {
		return "test";
	}
	
//	API login facebook: http://localhost:8080/tool/facebook/login
	@GetMapping("login")
	public String login() throws InterruptedException {
		service.loginFacebook();
		return "Login success";
	}
	
//	API login facebook: http://localhost:8080/tool/facebook/loginUseCookie
	@PostMapping("loginUseCookie")
	public String loginUseCookie(@RequestBody String cookie) throws InterruptedException {
		service.loginFacebookUseCookie(cookie);
		return "Login success";
	}
	
//	API login facebook: http://localhost:8080/tool/facebook/postStatus
	@GetMapping("postStatus")
	public String postStatus() {
		service.autoPostStatus();
		return "Post status success";
	}
}

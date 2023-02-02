package com.vinhlam.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vinhlam.tool.service.AutoPostStatusFacebook;

@SpringBootApplication
public class ToolFacebookApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ToolFacebookApplication.class, args);
		
//		AutoPostStatusFacebook tool = new AutoPostStatusFacebook();
//		tool.loginFacebook();
	}

}

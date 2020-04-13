package com.tcs.iprms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Value("${my.greeting: default value}")
	private String greetingMessage;
	
	@Value("some static message")
	private String staticMessage;

	@Value("${my.list.value}")
	private List<String> listValue;
	
	@Autowired
	private DbSettings dbSettings;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/greeting")
	public String greeting() {
		
		return "my.greeting: " + greetingMessage +"db.connection: " + dbSettings.getConnection();
	}
	
	@GetMapping("/envdetails")
	public String envDetails() {
		return  env.toString();
	}
}

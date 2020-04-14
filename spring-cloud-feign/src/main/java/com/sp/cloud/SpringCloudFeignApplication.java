package com.sp.cloud;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sp.cloud.client.UserClient;
import com.sp.cloud.dto.UserResponse;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableCircuitBreaker
public class SpringCloudFeignApplication {

	@Autowired
	private UserClient client;
	
	
	@GetMapping("/findAllUser")
	@HystrixCommand(fallbackMethod="getFallbackUser")
	public List<UserResponse> getAllUser(){
		
		return client.getUsers();
	}
	
	public List<UserResponse> getFallbackUser(){
		
		UserResponse user1=new UserResponse();
		
		user1.setEmail("pawanXXXXX@gmail.com");
		user1.setId(1);
		user1.setName("XXXXX");
		return Arrays.asList(user1);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignApplication.class, args);
	}

}

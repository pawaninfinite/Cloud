package com.sp.cloud.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.sp.cloud.dto.UserResponse;

@FeignClient(url="https://jsonplaceholder.typicode.com",name="User-Client")
public interface UserClient {

	@GetMapping("/users")
	public List<UserResponse> getUsers();
}

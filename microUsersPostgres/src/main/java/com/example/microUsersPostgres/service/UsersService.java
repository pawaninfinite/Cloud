package com.example.microUsersPostgres.service;

import com.example.microUsersPostgres.shared.UserDto;

public interface UsersService {
	UserDto createUser(UserDto userDetails);
}

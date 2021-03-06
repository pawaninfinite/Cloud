package com.example.microUsersPostgres.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microUsersPostgres.data.UserEntity;
import com.example.microUsersPostgres.data.UsersRepository;
import com.example.microUsersPostgres.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService {

	UsersRepository usersRepository;
	
	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	@Override
	public UserDto createUser(UserDto userDetails) {

		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper oModelMapper = new ModelMapper();
		oModelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity oUserEntity = oModelMapper.map(userDetails, UserEntity.class);
		oUserEntity.setEncryptedPassword("test");
		
		try{
			usersRepository.save(oUserEntity);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}

}

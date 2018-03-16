package com.example.mapper;

import com.example.entity.User;

public interface UserMapper {

	User selectByPrimaryKey(String id);

	void saveUser(User user);
	
}

package com.example.service;

import java.util.List;

import com.example.entity.User;


public interface IUserService {

	User getUserById(User u);

	void saveUser(User user);

	List<User> queryUserByPage(Integer page, Integer pageSize);

}

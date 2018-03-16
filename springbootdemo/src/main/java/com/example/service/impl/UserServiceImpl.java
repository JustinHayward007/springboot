package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public User getUserById(User u) {
		return mapper.selectByPrimaryKey(u.getId());
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveUser(User user) {
		mapper.saveUser(user);
		int a = 1 / 0;
		user.setAge(22);
	}

	@Override
	public List<User> queryUserByPage(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}

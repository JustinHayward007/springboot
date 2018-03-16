package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.SysUser;
import com.example.mapper.SysUserMapper;
import com.example.service.IMybatisService;

@Service
public class MybatisService implements IMybatisService {

	@Autowired
	private SysUserMapper mapper;
	
	@Override
	public void saveUser(SysUser user) {
		mapper.insert(user);
	}

	@Override
	public void updateUser(SysUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object queryUserById(String userId) {
		return mapper.selectByPrimaryKey("1803169G83X5SY80");
	}

	@Override
	public List<SysUser> queryUserList(SysUser user) {
		// TODO Auto-generated method stub
		return null;
	}

}

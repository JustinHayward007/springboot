package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.SysUser;
import com.example.mapper.SysUserMapper;
import com.example.service.IMybatisService;

@Service
public class MybatisService implements IMybatisService {

	@Autowired
	private SysUserMapper mapper;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveUser(SysUser user) {
		mapper.insert(user);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateUser(SysUser user) {
		mapper.updateByPrimaryKeySelective(user);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteUser(String userId) {
		mapper.deleteByPrimaryKey(userId);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Object queryUserById(String userId) {
		return mapper.selectByPrimaryKey("1803169G83X5SY80");
	}

	@Override
	public List<SysUser> queryUserList(SysUser user) {
		// TODO Auto-generated method stub
		return null;
	}

}

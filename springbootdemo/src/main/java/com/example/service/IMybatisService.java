package com.example.service;

import java.util.List;

import com.example.entity.SysUser;

public interface IMybatisService {

	void saveUser(SysUser user);

	void updateUser(SysUser user);

	void deleteUser(String userId);

	Object queryUserById(String userId);

	List<SysUser> queryUserList(SysUser user);

}

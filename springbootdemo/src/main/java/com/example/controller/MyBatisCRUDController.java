package com.example.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.JSONResult;
import com.example.entity.SysUser;
import com.example.service.IMybatisService;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private IMybatisService mybatisService;
	
	@Autowired
	private Sid sid;

	
	@RequestMapping("/saveUser")
	public JSONResult saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("imooc" + new Date());
		user.setNickname("imooc" + new Date());
		user.setPassword("abc123");
		mybatisService.saveUser(user);
		
		return JSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public JSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("10011001");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		mybatisService.updateUser(user);
		
		return JSONResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public JSONResult deleteUser(String userId) {
		
		mybatisService.deleteUser(userId);
		
		return JSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public JSONResult queryUserById(String userId) {
		SysUser u = (com.example.entity.SysUser) mybatisService.queryUserById(userId);
		return JSONResult.ok(u);
	}
	
	@RequestMapping("/queryUserList")
	public JSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("imooc");
		user.setNickname("lee");
		
		List<SysUser> userList = mybatisService.queryUserList(user);
		
		return JSONResult.ok(userList);
	}
	
	
}

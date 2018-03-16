package com.example.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.JSONResult;
import com.example.entity.Resource;
import com.example.entity.User;
import com.example.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {	
	
	@Autowired
	private Resource resource;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private Sid sid;
		
	@RequestMapping("/getUser")
	public JSONResult getUser() {
		User u=new User();
		u.setUserName("zhangsan11111111");
		u.setAge(24);
		u.setBirthday(new Date());
		u.setDesc(null);
		return JSONResult.ok(u);
	}
	
	@RequestMapping("/getResource")
	public JSONResult getResource() {
		Resource bean=new Resource();
		BeanUtils.copyProperties(resource, bean);
		return JSONResult.ok(bean);
	}
	
	@RequestMapping("/getUserById")
	public JSONResult getUserById() {
		User u=new User();
		u.setId("1");
		u=userService.getUserById(u);
		return JSONResult.ok(u);
		
	}
	
	@RequestMapping("/saveUser")
	public JSONResult saveUser() {
		String userId = sid.nextShort();
		User user=new User();
		user.setId(userId);
		user.setUserName("test"+new Date());
		user.setPassword("test"+new Date());
		user.setAge(23);
		user.setSex(1);
		
		userService.saveUser(user);
		return JSONResult.ok("保存成功");
	}
	
	
	@RequestMapping("/queryUserByPage")
	public JSONResult queryUserByPage(Integer page) {
		if(page==null) {
			page=1;
		}
		Integer pageSize=10;
		List<User> list=userService.queryUserByPage(page,pageSize);
		
		return JSONResult.ok(list);
	}

	

	


}

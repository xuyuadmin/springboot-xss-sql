package com.xuyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuyu.entity.UserEntity;
import com.xuyu.mapper.UserMapper;

@RestController
public class LoginController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/login")
	public String login(UserEntity userEntity) {
		System.out.println("账号密码信息:userEntity:" + userEntity.toString());
		UserEntity login = userMapper.login(userEntity);
		return login == null ? "登陆失败!" : "登陆成功!";
	}

}

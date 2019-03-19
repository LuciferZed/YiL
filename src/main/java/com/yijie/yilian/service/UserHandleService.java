package com.yijie.yilian.service;

import com.yijie.yilian.model.User;

public interface UserHandleService {
	
	//用户登录
	public User userLogin(User user);
	
	//用户注册
	public Integer userRegist(User user);

}

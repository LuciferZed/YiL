package com.yijie.yilian.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.yilian.model.User;
import com.yijie.yilian.service.UserHandleService;

@RestController
@RequestMapping("/userHandle")
public class UserHandleController {
	
	@Autowired
	private UserHandleService userHandleService;
	
	/**
	 * @描述 用户登录
	 * @param user
	 * @return
	 */
	@RequestMapping("/userLogin")
	public Map<String,Object> userLogin(User user){
		Map<String,Object> result = new HashMap<String,Object>();
		User u = userHandleService.userLogin(user);
		if(u == null){
			result.put("code", 0);
		}else{
			result.put("code", 1);
		}
		result.put("user", u);
		return result;
	}
	
	/**
	 * @描述 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping("/userRegist")
	public Map<String,Object> userRegist(User user){
		Map<String,Object> result = new HashMap<String,Object>();
		Integer code = userHandleService.userRegist(user);
		result.put("code", code);
		return result;
	}

}

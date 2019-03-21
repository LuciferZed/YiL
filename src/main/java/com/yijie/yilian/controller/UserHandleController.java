package com.yijie.yilian.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.yilian.model.User;
import com.yijie.yilian.service.UserHandleService;

/**
 * @描述 用户功能块
 * @author Lucifer
 *
 */
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
	@ResponseBody
	public Map<String,Object> userLogin(@RequestBody User user){
		System.err.println(user);
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
	@ResponseBody
	public Map<String,Object> userRegist(@RequestBody User user){
		Map<String,Object> result = new HashMap<String,Object>();
		Integer code = userHandleService.userRegist(user);
		result.put("code", code);
		return result;
	}
	
	/**
	 * @描述 验证用户账号是否已注册（如果已存在返回错误编码0，不存在返回成功编码1）
	 * @param num
	 * @return
	 */
	@RequestMapping("/userNumExist")
	@ResponseBody
	public Map<String,Object> userNumExist(@RequestBody String num){
		Map<String,Object> result = new HashMap<String,Object>();
		Integer code = userHandleService.userNumExist(num);
		result.put("code", code);
		return result;
	}
	
	
	/**
	 * @描述 验证用户账号是否已注册（如果已存在返回错误编码0，不存在返回成功编码1）
	 * @param num
	 * @return 
	 */
	@RequestMapping("/userPhoneExist")
	@ResponseBody
	public Map<String,Object> userPhoneExist(@RequestBody String phone){
		Map<String,Object> result = new HashMap<String,Object>();
		Integer code = userHandleService.userPhoneExist(phone);
		result.put("code", code);
		return result;
	}

}

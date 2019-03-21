package com.yijie.yilian.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.yilian.model.PhoneRev;
import com.yijie.yilian.model.User;
import com.yijie.yilian.service.UserHandleService;
import com.yijie.yilian.utils.PhoneExist;

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
	
	@Autowired
	private PhoneExist phoneExist;
	
	@Autowired
	private PhoneRev pr;
	
	/**
	 * @描述 用户登录
	 * @param user
	 * @return
	 */
	@RequestMapping("/userLogin")
	@ResponseBody
	public Map<String,Object> userLogin(@RequestBody User user){
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
	@RequestMapping("/userPhoneExist")
	@ResponseBody
	public Map<String,Object> userPhoneExist(@RequestBody String num){
		Map<String,Object> result = new HashMap<String,Object>();
		Integer code = userHandleService.userPhoneExist(num);
		result.put("code", code);
		return result;
	}
	
	/**
	 * @描述 手机验证码请求
	 * @param num
	 * @return
	 */
	@RequestMapping("noterev")
	@ResponseBody
	public Map<String,Object> noteRev(@RequestBody String num){
		Map<String,Object> result = new HashMap<String,Object>();
		String rev = phoneExist.noteRev(num);
		Integer code = 1;
		if(rev == null){
			code = 0;
		}
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time =dateFm.format(new Date());
		pr = new PhoneRev(rev, time);
		result.put("code", code);
		return result;
	}
	
	
	

}
